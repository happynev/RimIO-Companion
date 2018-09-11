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
 * <p>Java-Klasse für skillsDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="skillsDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="skills" type="{}skillsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "skillsDataType", propOrder = {
    "skills"
})
public class SkillsDataType {

    @XmlElement(required = true)
    protected SkillsType skills;

    /**
     * Ruft den Wert der skills-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SkillsType }
     *     
     */
    public SkillsType getSkills() {
        return skills;
    }

    /**
     * Legt den Wert der skills-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SkillsType }
     *     
     */
    public void setSkills(SkillsType value) {
        this.skills = value;
    }

}
