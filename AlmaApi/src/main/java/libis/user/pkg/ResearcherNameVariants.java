//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.04 at 12:19:36 PM CET 
//


package libis.user.pkg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of researcher's name variants.
 * 
 * <p>Java class for researcher_name_variants complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher_name_variants">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="researcher_name_variant" type="{}researcher_name_variant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher_name_variants", propOrder = {
    "researcherNameVariant"
})
public class ResearcherNameVariants {

    @XmlElement(name = "researcher_name_variant")
    protected List<ResearcherNameVariant> researcherNameVariant;

    /**
     * Gets the value of the researcherNameVariant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the researcherNameVariant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResearcherNameVariant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResearcherNameVariant }
     * 
     * 
     */
    public List<ResearcherNameVariant> getResearcherNameVariant() {
        if (researcherNameVariant == null) {
            researcherNameVariant = new ArrayList<ResearcherNameVariant>();
        }
        return this.researcherNameVariant;
    }

}