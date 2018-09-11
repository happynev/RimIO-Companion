//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.09.09 um 02:40:58 PM CEST 
//


package generated;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="dataVersion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tick" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="worldSeed" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="includesMaps" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includesPawns" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="maps" type="{}mapsType"/>
 *         &lt;element name="colonists" type="{}pawnType"/>
 *         &lt;element name="visitors" type="{}pawnType"/>
 *         &lt;element name="enemies" type="{}pawnType"/>
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
    "dataVersion",
    "tick",
    "worldSeed",
    "includesMaps",
    "includesPawns",
    "maps",
    "colonists",
    "visitors",
    "enemies"
})
@XmlRootElement(name = "GameData")
public class GameData {

    protected long dataVersion;
    protected long tick;
    @XmlElement(required = true)
    protected String worldSeed;
    protected boolean includesMaps;
    protected boolean includesPawns;
    @XmlElement(required = true)
    protected MapsType maps;
    @XmlElement(required = true)
    protected PawnType colonists;
    @XmlElement(required = true)
    protected PawnType visitors;
    @XmlElement(required = true)
    protected PawnType enemies;

    /**
     * Ruft den Wert der dataVersion-Eigenschaft ab.
     * 
     */
    public long getDataVersion() {
        return dataVersion;
    }

    /**
     * Legt den Wert der dataVersion-Eigenschaft fest.
     * 
     */
    public void setDataVersion(long value) {
        this.dataVersion = value;
    }

    /**
     * Ruft den Wert der tick-Eigenschaft ab.
     * 
     */
    public long getTick() {
        return tick;
    }

    /**
     * Legt den Wert der tick-Eigenschaft fest.
     * 
     */
    public void setTick(long value) {
        this.tick = value;
    }

    /**
     * Ruft den Wert der worldSeed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorldSeed() {
        return worldSeed;
    }

    /**
     * Legt den Wert der worldSeed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorldSeed(String value) {
        this.worldSeed = value;
    }

    /**
     * Ruft den Wert der includesMaps-Eigenschaft ab.
     * 
     */
    public boolean isIncludesMaps() {
        return includesMaps;
    }

    /**
     * Legt den Wert der includesMaps-Eigenschaft fest.
     * 
     */
    public void setIncludesMaps(boolean value) {
        this.includesMaps = value;
    }

    /**
     * Ruft den Wert der includesPawns-Eigenschaft ab.
     * 
     */
    public boolean isIncludesPawns() {
        return includesPawns;
    }

    /**
     * Legt den Wert der includesPawns-Eigenschaft fest.
     * 
     */
    public void setIncludesPawns(boolean value) {
        this.includesPawns = value;
    }

    /**
     * Ruft den Wert der maps-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MapsType }
     *     
     */
    public MapsType getMaps() {
        return maps;
    }

    /**
     * Legt den Wert der maps-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MapsType }
     *     
     */
    public void setMaps(MapsType value) {
        this.maps = value;
    }

    /**
     * Ruft den Wert der colonists-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PawnType }
     *     
     */
    public PawnType getColonists() {
        return colonists;
    }

    /**
     * Legt den Wert der colonists-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PawnType }
     *     
     */
    public void setColonists(PawnType value) {
        this.colonists = value;
    }

    /**
     * Ruft den Wert der visitors-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PawnType }
     *     
     */
    public PawnType getVisitors() {
        return visitors;
    }

    /**
     * Legt den Wert der visitors-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PawnType }
     *     
     */
    public void setVisitors(PawnType value) {
        this.visitors = value;
    }

    /**
     * Ruft den Wert der enemies-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PawnType }
     *     
     */
    public PawnType getEnemies() {
        return enemies;
    }

    /**
     * Legt den Wert der enemies-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PawnType }
     *     
     */
    public void setEnemies(PawnType value) {
        this.enemies = value;
    }

}
