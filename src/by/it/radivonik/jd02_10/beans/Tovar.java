package by.it.radivonik.jd02_10.beans;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tovar complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Tovar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EdIzm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Count" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Stoim" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PrNds" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Nds" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="StoimPoln" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tovar", propOrder = {
        "name",
        "edIzm",
        "count",
        "cena",
        "stoim",
        "prNds",
        "nds",
        "stoimPoln"
})
public class Tovar {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "EdIzm", required = true)
    protected String edIzm;
    @XmlElement(name = "Count", required = true)
    protected BigDecimal count;
    @XmlElement(name = "Cena", required = true)
    protected BigDecimal cena;
    @XmlElement(name = "Stoim", required = true)
    protected BigDecimal stoim;
    @XmlElement(name = "PrNds", required = true)
    protected BigDecimal prNds;
    @XmlElement(name = "Nds", required = true)
    protected BigDecimal nds;
    @XmlElement(name = "StoimPoln", required = true)
    protected BigDecimal stoimPoln;

    /**
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
     * Gets the value of the edIzm property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEdIzm() {
        return edIzm;
    }

    /**
     * Sets the value of the edIzm property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEdIzm(String value) {
        this.edIzm = value;
    }

    /**
     * Gets the value of the count property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCount(BigDecimal value) {
        this.count = value;
    }

    /**
     * Gets the value of the cena property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCena(BigDecimal value) {
        this.cena = value;
    }

    /**
     * Gets the value of the stoim property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getStoim() {
        return stoim;
    }

    /**
     * Sets the value of the stoim property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setStoim(BigDecimal value) {
        this.stoim = value;
    }

    /**
     * Gets the value of the prNds property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getPrNds() {
        return prNds;
    }

    /**
     * Sets the value of the prNds property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setPrNds(BigDecimal value) {
        this.prNds = value;
    }

    /**
     * Gets the value of the nds property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getNds() {
        return nds;
    }

    /**
     * Sets the value of the nds property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setNds(BigDecimal value) {
        this.nds = value;
    }

    /**
     * Gets the value of the stoimPoln property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getStoimPoln() {
        return stoimPoln;
    }

    /**
     * Sets the value of the stoimPoln property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setStoimPoln(BigDecimal value) {
        this.stoimPoln = value;
    }

    @Override
    public String toString() {
        return
            "Tovar{" +
            "name='" + name + "', edIzm='" + edIzm + "', " +
            "count=" + count + ", cena=" + cena + ", stoim=" + stoim + ", " +
            "prNds=" + prNds + ", nds=" + nds + ", stoimPoln=" + stoimPoln + "}";
    }
}
