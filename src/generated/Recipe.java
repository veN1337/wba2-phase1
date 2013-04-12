//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.6 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2013.04.12 um 01:18:35 PM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}title"/>
 *         &lt;element ref="{}difficulty"/>
 *         &lt;element ref="{}workingtime"/>
 *         &lt;element ref="{}kcal"/>
 *         &lt;element ref="{}ingredients"/>
 *         &lt;element ref="{}preperation"/>
 *         &lt;element ref="{}comments"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{}recipe_id use="required""/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "title",
    "difficulty",
    "workingtime",
    "kcal",
    "ingredients",
    "preperation",
    "comments"
})
@XmlRootElement(name = "recipe")
public class Recipe {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String difficulty;
    @XmlElement(required = true)
    protected String workingtime;
    protected int kcal;
    @XmlElement(required = true)
    protected Ingredients ingredients;
    @XmlElement(required = true)
    protected Preperation preperation;
    @XmlElement(required = true)
    protected Comments comments;
    @XmlAttribute(name = "recipe_id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String recipeId;

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Ruft den Wert der difficulty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Legt den Wert der difficulty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifficulty(String value) {
        this.difficulty = value;
    }

    /**
     * Ruft den Wert der workingtime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingtime() {
        return workingtime;
    }

    /**
     * Legt den Wert der workingtime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingtime(String value) {
        this.workingtime = value;
    }

    /**
     * Ruft den Wert der kcal-Eigenschaft ab.
     * 
     */
    public int getKcal() {
        return kcal;
    }

    /**
     * Legt den Wert der kcal-Eigenschaft fest.
     * 
     */
    public void setKcal(int value) {
        this.kcal = value;
    }

    /**
     * Ruft den Wert der ingredients-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ingredients }
     *     
     */
    public Ingredients getIngredients() {
        return ingredients;
    }

    /**
     * Legt den Wert der ingredients-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ingredients }
     *     
     */
    public void setIngredients(Ingredients value) {
        this.ingredients = value;
    }

    /**
     * Ruft den Wert der preperation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Preperation }
     *     
     */
    public Preperation getPreperation() {
        return preperation;
    }

    /**
     * Legt den Wert der preperation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Preperation }
     *     
     */
    public void setPreperation(Preperation value) {
        this.preperation = value;
    }

    /**
     * Ruft den Wert der comments-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Comments }
     *     
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * Legt den Wert der comments-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Comments }
     *     
     */
    public void setComments(Comments value) {
        this.comments = value;
    }

    /**
     * Ruft den Wert der recipeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipeId() {
        return recipeId;
    }

    /**
     * Legt den Wert der recipeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipeId(String value) {
        this.recipeId = value;
    }

}
