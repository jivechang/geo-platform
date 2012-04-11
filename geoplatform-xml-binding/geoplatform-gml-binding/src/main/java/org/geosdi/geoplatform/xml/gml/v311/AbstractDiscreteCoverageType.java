//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.10 at 05:35:20 PM CEST 
//


package org.geosdi.geoplatform.xml.gml.v311;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A discrete coverage consists of a domain set, range set and optionally a coverage function. The domain set consists of either geometry or temporal objects, finite in number. The range set is comprised of a finite number of attribute values each of which is associated to every direct position within any single spatiotemporal object in the domain. In other words, the range values are constant on each spatiotemporal object in the domain. This coverage function maps each element from the coverage domain to an element in its range. This definition conforms to ISO 19123.
 * 
 * <p>Java class for AbstractDiscreteCoverageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractDiscreteCoverageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCoverageType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}coverageFunction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractDiscreteCoverageType", propOrder = {
    "coverageFunction"
})
@XmlSeeAlso({
    MultiSolidCoverageType.class,
    GridCoverageType.class,
    RectifiedGridCoverageType.class,
    MultiCurveCoverageType.class,
    MultiPointCoverageType.class,
    MultiSurfaceCoverageType.class
})
public abstract class AbstractDiscreteCoverageType
    extends AbstractCoverageType
{

    protected CoverageFunctionType coverageFunction;

    /**
     * Gets the value of the coverageFunction property.
     * 
     * @return
     *     possible object is
     *     {@link CoverageFunctionType }
     *     
     */
    public CoverageFunctionType getCoverageFunction() {
        return coverageFunction;
    }

    /**
     * Sets the value of the coverageFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoverageFunctionType }
     *     
     */
    public void setCoverageFunction(CoverageFunctionType value) {
        this.coverageFunction = value;
    }

}
