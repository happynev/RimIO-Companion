//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.09.09 um 02:40:58 PM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für HediffDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HediffDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tendable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="tended" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="bleedRate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="pain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="healthPercentImpact" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="permanent" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HediffDataType", propOrder = {
    "label",
    "tendable",
    "tended",
    "bleedRate",
    "pain",
    "location",
    "healthPercentImpact",
    "permanent"
})
public class HediffDataType {

    @XmlElement(required = true)
    protected String label;
    protected boolean tendable;
    protected boolean tended;
    protected float bleedRate;
    protected float pain;
    protected String location;
    protected float healthPercentImpact;
    protected boolean permanent;

    /**
     * Ruft den Wert der label-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Legt den Wert der label-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Ruft den Wert der tendable-Eigenschaft ab.
     * 
     */
    public boolean isTendable() {
        return tendable;
    }

    /**
     * Legt den Wert der tendable-Eigenschaft fest.
     * 
     */
    public void setTendable(boolean value) {
        this.tendable = value;
    }

    /**
     * Ruft den Wert der tended-Eigenschaft ab.
     * 
     */
    public boolean isTended() {
        return tended;
    }

    /**
     * Legt den Wert der tended-Eigenschaft fest.
     * 
     */
    public void setTended(boolean value) {
        this.tended = value;
    }

    /**
     * Ruft den Wert der bleedRate-Eigenschaft ab.
     * 
     */
    public float getBleedRate() {
        return bleedRate;
    }

    /**
     * Legt den Wert der bleedRate-Eigenschaft fest.
     * 
     */
    public void setBleedRate(float value) {
        this.bleedRate = value;
    }

    /**
     * Ruft den Wert der pain-Eigenschaft ab.
     * 
     */
    public float getPain() {
        return pain;
    }

    /**
     * Legt den Wert der pain-Eigenschaft fest.
     * 
     */
    public void setPain(float value) {
        this.pain = value;
    }

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Ruft den Wert der healthPercentImpact-Eigenschaft ab.
     * 
     */
    public float getHealthPercentImpact() {
        return healthPercentImpact;
    }

    /**
     * Legt den Wert der healthPercentImpact-Eigenschaft fest.
     * 
     */
    public void setHealthPercentImpact(float value) {
        this.healthPercentImpact = value;
    }

    /**
     * Ruft den Wert der permanent-Eigenschaft ab.
     * 
     */
    public boolean isPermanent() {
        return permanent;
    }

    /**
     * Legt den Wert der permanent-Eigenschaft fest.
     * 
     */
    public void setPermanent(boolean value) {
        this.permanent = value;
    }

}
