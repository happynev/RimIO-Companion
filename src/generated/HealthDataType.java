//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.09.09 um 02:40:58 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für healthDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="healthDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hediffs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="HediffData" type="{}HediffDataType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthDataType", propOrder = {
    "hediffs"
})
public class HealthDataType {

    @XmlElement(required = true)
    protected HealthDataType.Hediffs hediffs;

    /**
     * Ruft den Wert der hediffs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HealthDataType.Hediffs }
     *     
     */
    public HealthDataType.Hediffs getHediffs() {
        return hediffs;
    }

    /**
     * Legt den Wert der hediffs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthDataType.Hediffs }
     *     
     */
    public void setHediffs(HealthDataType.Hediffs value) {
        this.hediffs = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="HediffData" type="{}HediffDataType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "hediffData"
    })
    public static class Hediffs {

        @XmlElement(name = "HediffData")
        protected List<HediffDataType> hediffData;

        /**
         * Gets the value of the hediffData property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the hediffData property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHediffData().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link HediffDataType }
         * 
         * 
         */
        public List<HediffDataType> getHediffData() {
            if (hediffData == null) {
                hediffData = new ArrayList<HediffDataType>();
            }
            return this.hediffData;
        }

    }

}
