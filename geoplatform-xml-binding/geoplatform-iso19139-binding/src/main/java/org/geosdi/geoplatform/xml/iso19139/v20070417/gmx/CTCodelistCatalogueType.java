//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139v20070417.gmx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for CT_CodelistCatalogue_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_CodelistCatalogue_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmx}AbstractCT_Catalogue_Type">
 *       &lt;sequence>
 *         &lt;element name="codelistItem" type="{http://www.isotc211.org/2005/gmx}CT_Codelist_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_CodelistCatalogue_Type", propOrder = {
    "codelistItem"
})
public class CTCodelistCatalogueType
    extends AbstractCTCatalogueType
    implements ToString
{

    @XmlElement(required = true)
    protected List<CTCodelistPropertyType> codelistItem;

    /**
     * Gets the value of the codelistItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codelistItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodelistItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTCodelistPropertyType }
     * 
     * 
     */
    public List<CTCodelistPropertyType> getCodelistItem() {
        if (codelistItem == null) {
            codelistItem = new ArrayList<CTCodelistPropertyType>();
        }
        return this.codelistItem;
    }

    public boolean isSetCodelistItem() {
        return ((this.codelistItem!= null)&&(!this.codelistItem.isEmpty()));
    }

    public void unsetCodelistItem() {
        this.codelistItem = null;
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
        super.appendFields(locator, buffer, strategy);
        {
            List<CTCodelistPropertyType> theCodelistItem;
            theCodelistItem = (this.isSetCodelistItem()?this.getCodelistItem():null);
            strategy.appendField(locator, this, "codelistItem", buffer, theCodelistItem);
        }
        return buffer;
    }

    public void setCodelistItem(List<CTCodelistPropertyType> value) {
        this.codelistItem = null;
        List<CTCodelistPropertyType> draftl = this.getCodelistItem();
        draftl.addAll(value);
    }

}