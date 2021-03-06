//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.04 at 12:19:36 PM CET 
//


package libis.user.pkg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Researcher information.
 * 					SIS:
 * 			
 * 
 * <p>Java class for researcher complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="researcher">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="default_publication_language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="researcher_alternate_emails" type="{}researcher_alternate_emails" minOccurs="0"/>
 *         &lt;element name="researcher_organization_affiliations" type="{}researcher_organization_affiliations" minOccurs="0"/>
 *         &lt;element name="researcher_previous_organization_affiliations" type="{}researcher_previous_organization_affiliations" minOccurs="0"/>
 *         &lt;element name="researcher_external_organization_affiliations" type="{}researcher_external_organization_affiliations" minOccurs="0"/>
 *         &lt;element name="researcher_previous_external_organization_affiliations" type="{}researcher_previous_external_organization_affiliations" minOccurs="0"/>
 *         &lt;element name="researcher_name_variants" type="{}researcher_name_variants" minOccurs="0"/>
 *         &lt;element name="researcher_research_topics" type="{}researcher_research_topics" minOccurs="0"/>
 *         &lt;element name="researcher_keywords" type="{}researcher_keywords" minOccurs="0"/>
 *         &lt;element name="researcher_associations" type="{}researcher_associations" minOccurs="0"/>
 *         &lt;element name="researcher_languages" type="{}researcher_languages" minOccurs="0"/>
 *         &lt;element name="researcher_honors" type="{}researcher_honors" minOccurs="0"/>
 *         &lt;element name="researcher_educations" type="{}researcher_educations" minOccurs="0"/>
 *         &lt;element name="researcher_descriptions" type="{}researcher_descriptions" minOccurs="0"/>
 *         &lt;element name="researcher_webpages" type="{}researcher_webpages" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "researcher", propOrder = {

})
public class Researcher {

    protected String position;
    @XmlElement(name = "default_publication_language")
    protected String defaultPublicationLanguage;
    @XmlElement(name = "researcher_alternate_emails")
    protected ResearcherAlternateEmails researcherAlternateEmails;
    @XmlElement(name = "researcher_organization_affiliations")
    protected ResearcherOrganizationAffiliations researcherOrganizationAffiliations;
    @XmlElement(name = "researcher_previous_organization_affiliations")
    protected ResearcherPreviousOrganizationAffiliations researcherPreviousOrganizationAffiliations;
    @XmlElement(name = "researcher_external_organization_affiliations")
    protected ResearcherExternalOrganizationAffiliations researcherExternalOrganizationAffiliations;
    @XmlElement(name = "researcher_previous_external_organization_affiliations")
    protected ResearcherPreviousExternalOrganizationAffiliations researcherPreviousExternalOrganizationAffiliations;
    @XmlElement(name = "researcher_name_variants")
    protected ResearcherNameVariants researcherNameVariants;
    @XmlElement(name = "researcher_research_topics")
    protected ResearcherResearchTopics researcherResearchTopics;
    @XmlElement(name = "researcher_keywords")
    protected ResearcherKeywords researcherKeywords;
    @XmlElement(name = "researcher_associations")
    protected ResearcherAssociations researcherAssociations;
    @XmlElement(name = "researcher_languages")
    protected ResearcherLanguages researcherLanguages;
    @XmlElement(name = "researcher_honors")
    protected ResearcherHonors researcherHonors;
    @XmlElement(name = "researcher_educations")
    protected ResearcherEducations researcherEducations;
    @XmlElement(name = "researcher_descriptions")
    protected ResearcherDescriptions researcherDescriptions;
    @XmlElement(name = "researcher_webpages")
    protected ResearcherWebpages researcherWebpages;

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosition(String value) {
        this.position = value;
    }

    /**
     * Gets the value of the defaultPublicationLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultPublicationLanguage() {
        return defaultPublicationLanguage;
    }

    /**
     * Sets the value of the defaultPublicationLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultPublicationLanguage(String value) {
        this.defaultPublicationLanguage = value;
    }

    /**
     * Gets the value of the researcherAlternateEmails property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherAlternateEmails }
     *     
     */
    public ResearcherAlternateEmails getResearcherAlternateEmails() {
        return researcherAlternateEmails;
    }

    /**
     * Sets the value of the researcherAlternateEmails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherAlternateEmails }
     *     
     */
    public void setResearcherAlternateEmails(ResearcherAlternateEmails value) {
        this.researcherAlternateEmails = value;
    }

    /**
     * Gets the value of the researcherOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherOrganizationAffiliations }
     *     
     */
    public ResearcherOrganizationAffiliations getResearcherOrganizationAffiliations() {
        return researcherOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherOrganizationAffiliations }
     *     
     */
    public void setResearcherOrganizationAffiliations(ResearcherOrganizationAffiliations value) {
        this.researcherOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherPreviousOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherPreviousOrganizationAffiliations }
     *     
     */
    public ResearcherPreviousOrganizationAffiliations getResearcherPreviousOrganizationAffiliations() {
        return researcherPreviousOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherPreviousOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherPreviousOrganizationAffiliations }
     *     
     */
    public void setResearcherPreviousOrganizationAffiliations(ResearcherPreviousOrganizationAffiliations value) {
        this.researcherPreviousOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherExternalOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherExternalOrganizationAffiliations }
     *     
     */
    public ResearcherExternalOrganizationAffiliations getResearcherExternalOrganizationAffiliations() {
        return researcherExternalOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherExternalOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherExternalOrganizationAffiliations }
     *     
     */
    public void setResearcherExternalOrganizationAffiliations(ResearcherExternalOrganizationAffiliations value) {
        this.researcherExternalOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherPreviousExternalOrganizationAffiliations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherPreviousExternalOrganizationAffiliations }
     *     
     */
    public ResearcherPreviousExternalOrganizationAffiliations getResearcherPreviousExternalOrganizationAffiliations() {
        return researcherPreviousExternalOrganizationAffiliations;
    }

    /**
     * Sets the value of the researcherPreviousExternalOrganizationAffiliations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherPreviousExternalOrganizationAffiliations }
     *     
     */
    public void setResearcherPreviousExternalOrganizationAffiliations(ResearcherPreviousExternalOrganizationAffiliations value) {
        this.researcherPreviousExternalOrganizationAffiliations = value;
    }

    /**
     * Gets the value of the researcherNameVariants property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherNameVariants }
     *     
     */
    public ResearcherNameVariants getResearcherNameVariants() {
        return researcherNameVariants;
    }

    /**
     * Sets the value of the researcherNameVariants property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherNameVariants }
     *     
     */
    public void setResearcherNameVariants(ResearcherNameVariants value) {
        this.researcherNameVariants = value;
    }

    /**
     * Gets the value of the researcherResearchTopics property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherResearchTopics }
     *     
     */
    public ResearcherResearchTopics getResearcherResearchTopics() {
        return researcherResearchTopics;
    }

    /**
     * Sets the value of the researcherResearchTopics property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherResearchTopics }
     *     
     */
    public void setResearcherResearchTopics(ResearcherResearchTopics value) {
        this.researcherResearchTopics = value;
    }

    /**
     * Gets the value of the researcherKeywords property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherKeywords }
     *     
     */
    public ResearcherKeywords getResearcherKeywords() {
        return researcherKeywords;
    }

    /**
     * Sets the value of the researcherKeywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherKeywords }
     *     
     */
    public void setResearcherKeywords(ResearcherKeywords value) {
        this.researcherKeywords = value;
    }

    /**
     * Gets the value of the researcherAssociations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherAssociations }
     *     
     */
    public ResearcherAssociations getResearcherAssociations() {
        return researcherAssociations;
    }

    /**
     * Sets the value of the researcherAssociations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherAssociations }
     *     
     */
    public void setResearcherAssociations(ResearcherAssociations value) {
        this.researcherAssociations = value;
    }

    /**
     * Gets the value of the researcherLanguages property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherLanguages }
     *     
     */
    public ResearcherLanguages getResearcherLanguages() {
        return researcherLanguages;
    }

    /**
     * Sets the value of the researcherLanguages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherLanguages }
     *     
     */
    public void setResearcherLanguages(ResearcherLanguages value) {
        this.researcherLanguages = value;
    }

    /**
     * Gets the value of the researcherHonors property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherHonors }
     *     
     */
    public ResearcherHonors getResearcherHonors() {
        return researcherHonors;
    }

    /**
     * Sets the value of the researcherHonors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherHonors }
     *     
     */
    public void setResearcherHonors(ResearcherHonors value) {
        this.researcherHonors = value;
    }

    /**
     * Gets the value of the researcherEducations property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherEducations }
     *     
     */
    public ResearcherEducations getResearcherEducations() {
        return researcherEducations;
    }

    /**
     * Sets the value of the researcherEducations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherEducations }
     *     
     */
    public void setResearcherEducations(ResearcherEducations value) {
        this.researcherEducations = value;
    }

    /**
     * Gets the value of the researcherDescriptions property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherDescriptions }
     *     
     */
    public ResearcherDescriptions getResearcherDescriptions() {
        return researcherDescriptions;
    }

    /**
     * Sets the value of the researcherDescriptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherDescriptions }
     *     
     */
    public void setResearcherDescriptions(ResearcherDescriptions value) {
        this.researcherDescriptions = value;
    }

    /**
     * Gets the value of the researcherWebpages property.
     * 
     * @return
     *     possible object is
     *     {@link ResearcherWebpages }
     *     
     */
    public ResearcherWebpages getResearcherWebpages() {
        return researcherWebpages;
    }

    /**
     * Sets the value of the researcherWebpages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResearcherWebpages }
     *     
     */
    public void setResearcherWebpages(ResearcherWebpages value) {
        this.researcherWebpages = value;
    }

}
