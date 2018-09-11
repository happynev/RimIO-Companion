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
 * <p>Java-Klasse für hediffsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="hediffsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HediffData" type="{}HediffDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hediffsType", propOrder = {
    "hediffData"
})
public class HediffsType {

    @XmlElement(name = "HediffData")
    protected HediffDataType hediffData;

    /**
     * Ruft den Wert der hediffData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HediffDataType }
     *     
     */
    public HediffDataType getHediffData() {
        return hediffData;
    }

    /**
     * Legt den Wert der hediffData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HediffDataType }
     *     
     */
    public void setHediffData(HediffDataType value) {
        this.hediffData = value;
    }

}
