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
 * <p>Java-Klasse für PawnDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PawnDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="includesSkills" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includesNeeds" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includesHealth" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includesJob" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="includesPortrait" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="onMap" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="colonist" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="visitor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="prisoner" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="enemy" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="drafted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="currentHealth" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="dead" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="downed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sleeping" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idle" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="medicalRest" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inMentalState" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="inAggroMentalState" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="location" type="{}locationType" minOccurs="0"/>
 *         &lt;element name="traits" type="{}traitsType" minOccurs="0"/>
 *         &lt;element name="skillsData" type="{}skillsDataType" minOccurs="0"/>
 *         &lt;element name="needData" type="{}needDataType" minOccurs="0"/>
 *         &lt;element name="healthData" type="{}healthDataType" minOccurs="0"/>
 *         &lt;element name="capacityData" type="{}capacityDataType" minOccurs="0"/>
 *         &lt;element name="job" type="{}jobType" minOccurs="0"/>
 *         &lt;element name="portrait" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PawnDataType", propOrder = {
    "id",
    "fullName",
    "nickName",
    "label",
    "includesSkills",
    "includesNeeds",
    "includesHealth",
    "includesJob",
    "includesPortrait",
    "onMap",
    "colonist",
    "visitor",
    "prisoner",
    "enemy",
    "drafted",
    "selected",
    "age",
    "currentHealth",
    "dead",
    "downed",
    "sleeping",
    "idle",
    "medicalRest",
    "inMentalState",
    "inAggroMentalState",
    "location",
    "traits",
    "skillsData",
    "needData",
    "healthData",
    "capacityData",
    "job",
    "portrait"
})
public class PawnDataType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String fullName;
    @XmlElement(required = true)
    protected String nickName;
    @XmlElement(required = true)
    protected String label;
    protected boolean includesSkills;
    protected boolean includesNeeds;
    protected boolean includesHealth;
    protected boolean includesJob;
    protected boolean includesPortrait;
    protected short onMap;
    protected boolean colonist;
    protected boolean visitor;
    protected boolean prisoner;
    protected boolean enemy;
    protected boolean drafted;
    protected boolean selected;
    protected float age;
    protected float currentHealth;
    protected boolean dead;
    protected boolean downed;
    protected boolean sleeping;
    protected boolean idle;
    protected boolean medicalRest;
    protected boolean inMentalState;
    protected boolean inAggroMentalState;
    protected LocationType location;
    protected TraitsType traits;
    protected SkillsDataType skillsData;
    protected NeedDataType needData;
    protected HealthDataType healthData;
    protected CapacityDataType capacityData;
    protected JobType job;
    protected byte[] portrait;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der fullName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Legt den Wert der fullName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Ruft den Wert der nickName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Legt den Wert der nickName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

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
     * Ruft den Wert der includesSkills-Eigenschaft ab.
     * 
     */
    public boolean isIncludesSkills() {
        return includesSkills;
    }

    /**
     * Legt den Wert der includesSkills-Eigenschaft fest.
     * 
     */
    public void setIncludesSkills(boolean value) {
        this.includesSkills = value;
    }

    /**
     * Ruft den Wert der includesNeeds-Eigenschaft ab.
     * 
     */
    public boolean isIncludesNeeds() {
        return includesNeeds;
    }

    /**
     * Legt den Wert der includesNeeds-Eigenschaft fest.
     * 
     */
    public void setIncludesNeeds(boolean value) {
        this.includesNeeds = value;
    }

    /**
     * Ruft den Wert der includesHealth-Eigenschaft ab.
     * 
     */
    public boolean isIncludesHealth() {
        return includesHealth;
    }

    /**
     * Legt den Wert der includesHealth-Eigenschaft fest.
     * 
     */
    public void setIncludesHealth(boolean value) {
        this.includesHealth = value;
    }

    /**
     * Ruft den Wert der includesJob-Eigenschaft ab.
     * 
     */
    public boolean isIncludesJob() {
        return includesJob;
    }

    /**
     * Legt den Wert der includesJob-Eigenschaft fest.
     * 
     */
    public void setIncludesJob(boolean value) {
        this.includesJob = value;
    }

    /**
     * Ruft den Wert der includesPortrait-Eigenschaft ab.
     * 
     */
    public boolean isIncludesPortrait() {
        return includesPortrait;
    }

    /**
     * Legt den Wert der includesPortrait-Eigenschaft fest.
     * 
     */
    public void setIncludesPortrait(boolean value) {
        this.includesPortrait = value;
    }

    /**
     * Ruft den Wert der onMap-Eigenschaft ab.
     * 
     */
    public short getOnMap() {
        return onMap;
    }

    /**
     * Legt den Wert der onMap-Eigenschaft fest.
     * 
     */
    public void setOnMap(short value) {
        this.onMap = value;
    }

    /**
     * Ruft den Wert der colonist-Eigenschaft ab.
     * 
     */
    public boolean isColonist() {
        return colonist;
    }

    /**
     * Legt den Wert der colonist-Eigenschaft fest.
     * 
     */
    public void setColonist(boolean value) {
        this.colonist = value;
    }

    /**
     * Ruft den Wert der visitor-Eigenschaft ab.
     * 
     */
    public boolean isVisitor() {
        return visitor;
    }

    /**
     * Legt den Wert der visitor-Eigenschaft fest.
     * 
     */
    public void setVisitor(boolean value) {
        this.visitor = value;
    }

    /**
     * Ruft den Wert der prisoner-Eigenschaft ab.
     * 
     */
    public boolean isPrisoner() {
        return prisoner;
    }

    /**
     * Legt den Wert der prisoner-Eigenschaft fest.
     * 
     */
    public void setPrisoner(boolean value) {
        this.prisoner = value;
    }

    /**
     * Ruft den Wert der enemy-Eigenschaft ab.
     * 
     */
    public boolean isEnemy() {
        return enemy;
    }

    /**
     * Legt den Wert der enemy-Eigenschaft fest.
     * 
     */
    public void setEnemy(boolean value) {
        this.enemy = value;
    }

    /**
     * Ruft den Wert der drafted-Eigenschaft ab.
     * 
     */
    public boolean isDrafted() {
        return drafted;
    }

    /**
     * Legt den Wert der drafted-Eigenschaft fest.
     * 
     */
    public void setDrafted(boolean value) {
        this.drafted = value;
    }

    /**
     * Ruft den Wert der selected-Eigenschaft ab.
     * 
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Legt den Wert der selected-Eigenschaft fest.
     * 
     */
    public void setSelected(boolean value) {
        this.selected = value;
    }

    /**
     * Ruft den Wert der age-Eigenschaft ab.
     * 
     */
    public float getAge() {
        return age;
    }

    /**
     * Legt den Wert der age-Eigenschaft fest.
     * 
     */
    public void setAge(float value) {
        this.age = value;
    }

    /**
     * Ruft den Wert der currentHealth-Eigenschaft ab.
     * 
     */
    public float getCurrentHealth() {
        return currentHealth;
    }

    /**
     * Legt den Wert der currentHealth-Eigenschaft fest.
     * 
     */
    public void setCurrentHealth(float value) {
        this.currentHealth = value;
    }

    /**
     * Ruft den Wert der dead-Eigenschaft ab.
     * 
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * Legt den Wert der dead-Eigenschaft fest.
     * 
     */
    public void setDead(boolean value) {
        this.dead = value;
    }

    /**
     * Ruft den Wert der downed-Eigenschaft ab.
     * 
     */
    public boolean isDowned() {
        return downed;
    }

    /**
     * Legt den Wert der downed-Eigenschaft fest.
     * 
     */
    public void setDowned(boolean value) {
        this.downed = value;
    }

    /**
     * Ruft den Wert der sleeping-Eigenschaft ab.
     * 
     */
    public boolean isSleeping() {
        return sleeping;
    }

    /**
     * Legt den Wert der sleeping-Eigenschaft fest.
     * 
     */
    public void setSleeping(boolean value) {
        this.sleeping = value;
    }

    /**
     * Ruft den Wert der idle-Eigenschaft ab.
     * 
     */
    public boolean isIdle() {
        return idle;
    }

    /**
     * Legt den Wert der idle-Eigenschaft fest.
     * 
     */
    public void setIdle(boolean value) {
        this.idle = value;
    }

    /**
     * Ruft den Wert der medicalRest-Eigenschaft ab.
     * 
     */
    public boolean isMedicalRest() {
        return medicalRest;
    }

    /**
     * Legt den Wert der medicalRest-Eigenschaft fest.
     * 
     */
    public void setMedicalRest(boolean value) {
        this.medicalRest = value;
    }

    /**
     * Ruft den Wert der inMentalState-Eigenschaft ab.
     * 
     */
    public boolean isInMentalState() {
        return inMentalState;
    }

    /**
     * Legt den Wert der inMentalState-Eigenschaft fest.
     * 
     */
    public void setInMentalState(boolean value) {
        this.inMentalState = value;
    }

    /**
     * Ruft den Wert der inAggroMentalState-Eigenschaft ab.
     * 
     */
    public boolean isInAggroMentalState() {
        return inAggroMentalState;
    }

    /**
     * Legt den Wert der inAggroMentalState-Eigenschaft fest.
     * 
     */
    public void setInAggroMentalState(boolean value) {
        this.inAggroMentalState = value;
    }

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Ruft den Wert der traits-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TraitsType }
     *     
     */
    public TraitsType getTraits() {
        return traits;
    }

    /**
     * Legt den Wert der traits-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TraitsType }
     *     
     */
    public void setTraits(TraitsType value) {
        this.traits = value;
    }

    /**
     * Ruft den Wert der skillsData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SkillsDataType }
     *     
     */
    public SkillsDataType getSkillsData() {
        return skillsData;
    }

    /**
     * Legt den Wert der skillsData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SkillsDataType }
     *     
     */
    public void setSkillsData(SkillsDataType value) {
        this.skillsData = value;
    }

    /**
     * Ruft den Wert der needData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NeedDataType }
     *     
     */
    public NeedDataType getNeedData() {
        return needData;
    }

    /**
     * Legt den Wert der needData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NeedDataType }
     *     
     */
    public void setNeedData(NeedDataType value) {
        this.needData = value;
    }

    /**
     * Ruft den Wert der healthData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HealthDataType }
     *     
     */
    public HealthDataType getHealthData() {
        return healthData;
    }

    /**
     * Legt den Wert der healthData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthDataType }
     *     
     */
    public void setHealthData(HealthDataType value) {
        this.healthData = value;
    }

    /**
     * Ruft den Wert der capacityData-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CapacityDataType }
     *     
     */
    public CapacityDataType getCapacityData() {
        return capacityData;
    }

    /**
     * Legt den Wert der capacityData-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CapacityDataType }
     *     
     */
    public void setCapacityData(CapacityDataType value) {
        this.capacityData = value;
    }

    /**
     * Ruft den Wert der job-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JobType }
     *     
     */
    public JobType getJob() {
        return job;
    }

    /**
     * Legt den Wert der job-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JobType }
     *     
     */
    public void setJob(JobType value) {
        this.job = value;
    }

    /**
     * Ruft den Wert der portrait-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPortrait() {
        return portrait;
    }

    /**
     * Legt den Wert der portrait-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPortrait(byte[] value) {
        this.portrait = value;
    }

}
