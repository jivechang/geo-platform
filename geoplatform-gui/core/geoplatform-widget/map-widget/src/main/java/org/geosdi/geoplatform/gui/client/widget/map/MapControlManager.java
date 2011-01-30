/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-plartform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2011 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.gui.client.widget.map;

import org.geosdi.geoplatform.gui.client.widget.map.control.DrawPointFeature;
import org.geosdi.geoplatform.gui.client.widget.map.control.DrawPolygonControl;
import org.geosdi.geoplatform.gui.client.widget.map.control.ModifyFeatureControl;
import org.geosdi.geoplatform.gui.client.widget.map.control.crud.GenericFeatureOperation;
import org.geosdi.geoplatform.gui.client.widget.map.control.history.NavigationHistoryControl;
import org.geosdi.geoplatform.gui.client.widget.map.style.VectorFeatureStyle;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.DrawFeature;
import org.gwtopenmaps.openlayers.client.control.ModifyFeature;
import org.gwtopenmaps.openlayers.client.control.SelectFeature;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.geometry.Geometry;
import org.gwtopenmaps.openlayers.client.geometry.MultiPolygon;
import org.gwtopenmaps.openlayers.client.layer.Vector;
import org.gwtopenmaps.openlayers.client.layer.VectorOptions;

/**
 * @author giuseppe
 * 
 */
public class MapControlManager {

	private Map map;
	private Vector vector;
	private VectorFeatureStyle style;

	private DrawPolygonControl drawFeature;
	private DrawPointFeature drawPointFeature;
	private ModifyFeatureControl modifyFeature;
	private GenericFeatureOperation featureOperation;

	private NavigationHistoryControl navigationHistory;

	public MapControlManager(Map map) {
		this.map = map;
		this.style = new VectorFeatureStyle();
		this.initVectorLayer();
	}

	/**
	 * Create a vector layer to add to the map which defines a set of controls
	 * 
	 */
	private void initVectorLayer() {
		VectorOptions vectorOption = new VectorOptions();
		vectorOption.setStyle(this.style.getVectorStyle());
		vectorOption.setDisplayInLayerSwitcher(false);
		this.vector = new Vector("GeoPlatform Vector Layer", vectorOption);
		this.map.addLayer(vector);
	
		this.initControl();

		this.addMapControl();
	}

	/**
	 * Initialize Control on Vector Layer
	 * 
	 */
	private void initControl() {
		this.drawFeature = new DrawPolygonControl(vector);
		this.drawPointFeature = new DrawPointFeature(vector);
		this.modifyFeature = new ModifyFeatureControl(vector);
		this.featureOperation = new GenericFeatureOperation(vector);
		this.navigationHistory = new NavigationHistoryControl();
	}

	/**
	 * Add Control to the Map
	 * 
	 */
	private void addMapControl() {
		this.map.addControl(this.drawFeature.getControl());
		this.map.addControl(this.drawPointFeature.getControl());
		this.map.addControl(this.modifyFeature.getControl());
		this.map.addControl(this.featureOperation.getControl());
		this.map.addControl(this.navigationHistory.getControl());
		
		this.modifyFeature.activateControl();
	}

	/**
	 * Draw AOE on the Map
	 * 
	 * @param wkt
	 */
	public void drawAoeOnMap(String wkt) {
		MultiPolygon geom = MultiPolygon.narrowToMultiPolygon(Geometry.fromWKT(
				wkt).getJSObject());
		geom.transform(new Projection("EPSG:4326"), new Projection(
				"EPSG:900913"));
		VectorFeature vectorFeature = new VectorFeature(geom);
		this.vector.addFeature(vectorFeature);
		this.map.zoomToExtent(geom.getBounds());
	}

	/**
	 * 
	 * @param feature
	 */
	public void drawAOE(VectorFeature feature) {
		this.vector.addFeature(feature);
		this.map.zoomToExtent(feature.getGeometry().getBounds());
	}

	/**
	 * Erase all Features added to Vector Layer
	 */
	public void eraseFeatures() {
		this.vector.destroyFeatures();
	}

	/**
	 * Erase Single Feature from the Map
	 * 
	 * @param vf
	 */
	public void eraseFeature(VectorFeature vf) {
		this.vector.removeFeature(vf);
	}

	/**
	 * activate draw feature control on the map
	 */
	public void activateDrawFeature() {
		this.drawFeature.activateControl();
	}

	/**
	 * deactivate draw feature control on the map
	 */
	public void deactivateDrawFeature() {
		this.drawFeature.deactivateControl();
	}

	/**
	 * 
	 * @return DrawFeature
	 */
	public DrawFeature getDrawFeatureControl() {
		return this.drawFeature.getControl();
	}

	public DrawFeature getDrawPointFeaureControl() {
		return this.drawPointFeature.getControl();
	}

	/**
	 * 
	 * @return ModifyFeature
	 */
	public ModifyFeature getModifyFeatureControl() {
		return this.modifyFeature.getControl();
	}

	/**
	 * 
	 * @return SelectFeature
	 */
	public SelectFeature getSelectFeatureControl() {
		return this.featureOperation.getControl();
	}

	/**
	 * @return the featureOperation
	 */
	public GenericFeatureOperation getFeatureOperation() {
		return featureOperation;
	}

	/**
	 * @return the navigationHistory
	 */
	public NavigationHistoryControl getNavigationHistory() {
		return navigationHistory;
	}

	/**
	 * Redraw the Vector Layer
	 */
	public void redrawVectorLayer() {
		this.vector.redraw();
	}

	public void activateDrawPointFeature() {
		this.drawPointFeature.activateControl();
	}

	public void deactivateDrawPointFeature() {
		this.drawPointFeature.deactivateControl();
	}

	public void activateFeatureOperation() {
		this.featureOperation.activateControl();
	}

	public void deactivateFeatureOperation() {
		this.featureOperation.deactivateControl();
	}

	public boolean isFeatureOperationEnable() {
		return this.featureOperation.isEnabled();
	}

	public void activateModifyFeature() {
		this.modifyFeature.activateControl();
	}

	public void deactivateModifyFeature() {
		this.modifyFeature.deactivateControl();
	}

	public boolean isModifyFeatureEnable() {
		return this.modifyFeature.isEnabled();
	}

	public int getFeaturesNumber() {
		return this.vector.getNumberOfFeatures();
	}

	public void clearNavigationHistory() {
		this.navigationHistory.clearHistory();
	}

	public void activateNavigationHistory() {
		this.navigationHistory.activateControl();
	}

	public void deactivateNavigationHistory() {
		this.navigationHistory.deactivateControl();
	}
}
