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
 * <p>Java-Klasse für capacityDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="capacityDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacities" type="{}capacitiesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "capacityDataType", propOrder = {
    "capacities"
})
public class CapacityDataType {

    @XmlElement(required = true)
    protected CapacitiesType capacities;

    /**
     * Ruft den Wert der capacities-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CapacitiesType }
     *     
     */
    public CapacitiesType getCapacities() {
        return capacities;
    }

    /**
     * Legt den Wert der capacities-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CapacitiesType }
     *     
     */
    public void setCapacities(CapacitiesType value) {
        this.capacities = value;
    }

}
