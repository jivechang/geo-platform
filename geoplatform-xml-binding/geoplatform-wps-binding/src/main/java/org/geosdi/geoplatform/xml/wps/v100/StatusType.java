/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2015 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.16 at 12:48:05 PM CEST 
//


package org.geosdi.geoplatform.xml.wps.v100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Description of the status of process execution. 
 * 
 * <p>Java class for StatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="ProcessAccepted" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProcessStarted" type="{http://www.opengis.net/wps/1.0.0}ProcessStartedType"/>
 *         &lt;element name="ProcessPaused" type="{http://www.opengis.net/wps/1.0.0}ProcessStartedType"/>
 *         &lt;element name="ProcessSucceeded" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProcessFailed" type="{http://www.opengis.net/wps/1.0.0}ProcessFailedType"/>
 *       &lt;/choice>
 *       &lt;attribute name="creationTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusType", propOrder = {
    "processAccepted",
    "processStarted",
    "processPaused",
    "processSucceeded",
    "processFailed"
})
public class StatusType
    implements ToString
{

    @XmlElement(name = "ProcessAccepted")
    protected String processAccepted;
    @XmlElement(name = "ProcessStarted")
    protected ProcessStartedType processStarted;
    @XmlElement(name = "ProcessPaused")
    protected ProcessStartedType processPaused;
    @XmlElement(name = "ProcessSucceeded")
    protected String processSucceeded;
    @XmlElement(name = "ProcessFailed")
    protected ProcessFailedType processFailed;
    @XmlAttribute(name = "creationTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;

    /**
     * Gets the value of the processAccepted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessAccepted() {
        return processAccepted;
    }

    /**
     * Sets the value of the processAccepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessAccepted(String value) {
        this.processAccepted = value;
    }

    public boolean isSetProcessAccepted() {
        return (this.processAccepted!= null);
    }

    /**
     * Gets the value of the processStarted property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessStartedType }
     *     
     */
    public ProcessStartedType getProcessStarted() {
        return processStarted;
    }

    /**
     * Sets the value of the processStarted property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessStartedType }
     *     
     */
    public void setProcessStarted(ProcessStartedType value) {
        this.processStarted = value;
    }

    public boolean isSetProcessStarted() {
        return (this.processStarted!= null);
    }

    /**
     * Gets the value of the processPaused property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessStartedType }
     *     
     */
    public ProcessStartedType getProcessPaused() {
        return processPaused;
    }

    /**
     * Sets the value of the processPaused property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessStartedType }
     *     
     */
    public void setProcessPaused(ProcessStartedType value) {
        this.processPaused = value;
    }

    public boolean isSetProcessPaused() {
        return (this.processPaused!= null);
    }

    /**
     * Gets the value of the processSucceeded property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessSucceeded() {
        return processSucceeded;
    }

    /**
     * Sets the value of the processSucceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessSucceeded(String value) {
        this.processSucceeded = value;
    }

    public boolean isSetProcessSucceeded() {
        return (this.processSucceeded!= null);
    }

    /**
     * Gets the value of the processFailed property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessFailedType }
     *     
     */
    public ProcessFailedType getProcessFailed() {
        return processFailed;
    }

    /**
     * Sets the value of the processFailed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessFailedType }
     *     
     */
    public void setProcessFailed(ProcessFailedType value) {
        this.processFailed = value;
    }

    public boolean isSetProcessFailed() {
        return (this.processFailed!= null);
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    public boolean isSetCreationTime() {
        return (this.creationTime!= null);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            String theProcessAccepted;
            theProcessAccepted = this.getProcessAccepted();
            strategy.appendField(locator, this, "processAccepted", buffer, theProcessAccepted);
        }
        {
            ProcessStartedType theProcessStarted;
            theProcessStarted = this.getProcessStarted();
            strategy.appendField(locator, this, "processStarted", buffer, theProcessStarted);
        }
        {
            ProcessStartedType theProcessPaused;
            theProcessPaused = this.getProcessPaused();
            strategy.appendField(locator, this, "processPaused", buffer, theProcessPaused);
        }
        {
            String theProcessSucceeded;
            theProcessSucceeded = this.getProcessSucceeded();
            strategy.appendField(locator, this, "processSucceeded", buffer, theProcessSucceeded);
        }
        {
            ProcessFailedType theProcessFailed;
            theProcessFailed = this.getProcessFailed();
            strategy.appendField(locator, this, "processFailed", buffer, theProcessFailed);
        }
        {
            XMLGregorianCalendar theCreationTime;
            theCreationTime = this.getCreationTime();
            strategy.appendField(locator, this, "creationTime", buffer, theCreationTime);
        }
        return buffer;
    }

}
