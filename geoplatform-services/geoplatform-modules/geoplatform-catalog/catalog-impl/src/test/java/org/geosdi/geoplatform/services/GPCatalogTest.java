/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
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
package org.geosdi.geoplatform.services;

import it.geosolutions.geonetwork.exception.GNLibException;
import it.geosolutions.geonetwork.exception.GNServerException;
import it.geosolutions.geonetwork.util.GNSearchResponse;
import java.util.logging.Level;
import org.geosdi.geoplatform.exception.GPCatalogException;
import org.geosdi.geoplatform.exception.GPCatalogLoginException;
import org.geosdi.geoplatform.services.util.GPCatalogClient;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Michele Santomauro - CNR IMAA geoSDI Group
 * @email michele.santomauro@geosdi.org
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GPCatalogTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Autowired
    private GPCatalogClient gpCatalogClient;
    //
    @Autowired
    private GPCatalogFinderService gpCatalogFinderService;
    //

    @Test
    public void testGPCatalogClientReferences() {
        Assert.assertNotNull("gpCatalogClient is null", gpCatalogClient);

        Assert.assertNotNull("URL of GeoNetwork is null", gpCatalogClient.getGeoNetworkServiceURL());
        Assert.assertNotNull("username of GeoNetwork is null", gpCatalogClient.getGeoNetworkUsername());
        Assert.assertNotNull("password of GeoNetwork is null", gpCatalogClient.getGeoNetworkPassword());
    }

    @Test
    public void testGPCatalogFinderServiceReferences() {
        Assert.assertNotNull("gpCatalogFinderService is null", gpCatalogFinderService);
    }

    @Test
    public void testGPCatalogClient() {
        try {
            gpCatalogClient.login();
        } catch (GPCatalogLoginException ex) {
            Assert.fail(ex.getMessage());
        }
    }

//    @Test
//    public void testWrongURL() {
//        gpCatalogClient.setGeoNetworkServiceURL("http://localhost:8282/geonetwork");
//        try {
//            gpCatalogClient.login();
//            Assert.fail("Impossible to make login because GeoNetwork service URL is wrong");
//        } catch (GPCatalogLoginException ex) {
//        }
//    }
//
//    @Test
//    public void testWrongCredentials() {
//        gpCatalogClient.setGeoNetworkUsername("admin");
//        gpCatalogClient.setGeoNetworkPassword("aadminn");
//        try {
//            gpCatalogClient.login();
//            Assert.fail("Impossible to make login because password is wrong");
//        } catch (GPCatalogLoginException ex) {
//            Assert.fail(ex.getMessage());
//        }
//    }
    @Test
    public void testGPCatalogFinderService() {
        try {
            GNSearchResponse searchResponse = this.gpCatalogFinderService.searchMetadata("Manhattan");

            if (searchResponse.getCount() != 0) {
                // loop on all metadata
                for (GNSearchResponse.GNMetadata metadata : searchResponse) {
                    Long id = metadata.getId();
                    // and this is the full metadata document, as a JDOM element.
                    Element md = gpCatalogClient.login().get(id);
                    XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
                    logger.info("Metadata -> " + out.outputString(md));
                }
            } else {
                logger.info("No data retrieved");
            }
        } catch (GNLibException ex) {
            Assert.fail(ex.getMessage());
        } catch (GNServerException ex) {
            Assert.fail(ex.getMessage());
        } catch (GPCatalogException ex) {
            Assert.fail(ex.getMessage());
        }
    }
}