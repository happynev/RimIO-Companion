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
 * <p>Java-Klasse für skillDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="skillDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="passion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="level" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="xpProgress" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="totalXp" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="currentXp" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="levelupXp" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skillDataType", propOrder = {
    "name",
    "passion",
    "level",
    "enabled",
    "xpProgress",
    "totalXp",
    "currentXp",
    "levelupXp"
})
public class SkillDataType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String passion;
    protected short level;
    protected boolean enabled;
    protected float xpProgress;
    protected float totalXp;
    protected float currentXp;
    protected float levelupXp;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der passion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassion() {
        return passion;
    }

    /**
     * Legt den Wert der passion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassion(String value) {
        this.passion = value;
    }

    /**
     * Ruft den Wert der level-Eigenschaft ab.
     * 
     */
    public short getLevel() {
        return level;
    }

    /**
     * Legt den Wert der level-Eigenschaft fest.
     * 
     */
    public void setLevel(short value) {
        this.level = value;
    }

    /**
     * Ruft den Wert der enabled-Eigenschaft ab.
     * 
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Legt den Wert der enabled-Eigenschaft fest.
     * 
     */
    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    /**
     * Ruft den Wert der xpProgress-Eigenschaft ab.
     * 
     */
    public float getXpProgress() {
        return xpProgress;
    }

    /**
     * Legt den Wert der xpProgress-Eigenschaft fest.
     * 
     */
    public void setXpProgress(float value) {
        this.xpProgress = value;
    }

    /**
     * Ruft den Wert der totalXp-Eigenschaft ab.
     * 
     */
    public float getTotalXp() {
        return totalXp;
    }

    /**
     * Legt den Wert der totalXp-Eigenschaft fest.
     * 
     */
    public void setTotalXp(float value) {
        this.totalXp = value;
    }

    /**
     * Ruft den Wert der currentXp-Eigenschaft ab.
     * 
     */
    public float getCurrentXp() {
        return currentXp;
    }

    /**
     * Legt den Wert der currentXp-Eigenschaft fest.
     * 
     */
    public void setCurrentXp(float value) {
        this.currentXp = value;
    }

    /**
     * Ruft den Wert der levelupXp-Eigenschaft ab.
     * 
     */
    public float getLevelupXp() {
        return levelupXp;
    }

    /**
     * Legt den Wert der levelupXp-Eigenschaft fest.
     * 
     */
    public void setLevelupXp(float value) {
        this.levelupXp = value;
    }

}
