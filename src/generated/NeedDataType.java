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
 * <p>Java-Klasse für needDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="needDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="needs" type="{}needsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "needDataType", propOrder = {
    "needs"
})
public class NeedDataType {

    @XmlElement(required = true)
    protected NeedsType needs;

    /**
     * Ruft den Wert der needs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NeedsType }
     *     
     */
    public NeedsType getNeeds() {
        return needs;
    }

    /**
     * Legt den Wert der needs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedsType }
     *     
     */
    public void setNeeds(NeedsType value) {
        this.needs = value;
    }

}
