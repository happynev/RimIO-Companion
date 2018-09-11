//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.09.09 um 02:40:58 PM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für MapDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MapDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="colony" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sizeX" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="sizeY" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="wealthFloors" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="wealthBuildings" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="wealthItems" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="wealthPawns" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="wealthTotal" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapDataType", propOrder = {
    "id",
    "colony",
    "sizeX",
    "sizeY",
    "wealthFloors",
    "wealthBuildings",
    "wealthItems",
    "wealthPawns",
    "wealthTotal"
})
public class MapDataType {

    protected int id;
    protected boolean colony;
    protected short sizeX;
    protected short sizeY;
    protected float wealthFloors;
    protected float wealthBuildings;
    protected float wealthItems;
    protected float wealthPawns;
    protected float wealthTotal;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der colony-Eigenschaft ab.
     * 
     */
    public boolean isColony() {
        return colony;
    }

    /**
     * Legt den Wert der colony-Eigenschaft fest.
     * 
     */
    public void setColony(boolean value) {
        this.colony = value;
    }

    /**
     * Ruft den Wert der sizeX-Eigenschaft ab.
     * 
     */
    public short getSizeX() {
        return sizeX;
    }

    /**
     * Legt den Wert der sizeX-Eigenschaft fest.
     * 
     */
    public void setSizeX(short value) {
        this.sizeX = value;
    }

    /**
     * Ruft den Wert der sizeY-Eigenschaft ab.
     * 
     */
    public short getSizeY() {
        return sizeY;
    }

    /**
     * Legt den Wert der sizeY-Eigenschaft fest.
     * 
     */
    public void setSizeY(short value) {
        this.sizeY = value;
    }

    /**
     * Ruft den Wert der wealthFloors-Eigenschaft ab.
     * 
     */
    public float getWealthFloors() {
        return wealthFloors;
    }

    /**
     * Legt den Wert der wealthFloors-Eigenschaft fest.
     * 
     */
    public void setWealthFloors(float value) {
        this.wealthFloors = value;
    }

    /**
     * Ruft den Wert der wealthBuildings-Eigenschaft ab.
     * 
     */
    public float getWealthBuildings() {
        return wealthBuildings;
    }

    /**
     * Legt den Wert der wealthBuildings-Eigenschaft fest.
     * 
     */
    public void setWealthBuildings(float value) {
        this.wealthBuildings = value;
    }

    /**
     * Ruft den Wert der wealthItems-Eigenschaft ab.
     * 
     */
    public float getWealthItems() {
        return wealthItems;
    }

    /**
     * Legt den Wert der wealthItems-Eigenschaft fest.
     * 
     */
    public void setWealthItems(float value) {
        this.wealthItems = value;
    }

    /**
     * Ruft den Wert der wealthPawns-Eigenschaft ab.
     * 
     */
    public float getWealthPawns() {
        return wealthPawns;
    }

    /**
     * Legt den Wert der wealthPawns-Eigenschaft fest.
     * 
     */
    public void setWealthPawns(float value) {
        this.wealthPawns = value;
    }

    /**
     * Ruft den Wert der wealthTotal-Eigenschaft ab.
     * 
     */
    public float getWealthTotal() {
        return wealthTotal;
    }

    /**
     * Legt den Wert der wealthTotal-Eigenschaft fest.
     * 
     */
    public void setWealthTotal(float value) {
        this.wealthTotal = value;
    }

}
