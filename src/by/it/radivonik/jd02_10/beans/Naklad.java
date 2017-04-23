package by.it.radivonik.jd02_10.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.text.*;
import java.util.Date;


/**
 * <p>Java class for Naklad complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Naklad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Num" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Seria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Klient" type="{http://generate.beans.jd02_09.radivonik.it.by}Klient"/>
 *         &lt;element name="Avto" type="{http://generate.beans.jd02_09.radivonik.it.by}Avto"/>
 *         &lt;element name="Tovars" type="{http://generate.beans.jd02_09.radivonik.it.by}Tovars"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://generate.beans.jd02_09.radivonik.it.by}NakladType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Naklad", propOrder = {
        "date",
        "num",
        "seria",
        "klient",
        "avto",
        "tovars"
})
public class Naklad {

    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected Date date;
    @XmlElement(name = "Num", required = true)
    protected String num;
    @XmlElement(name = "Seria", required = true)
    protected String seria;
    @XmlElement(name = "Klient", required = true)
    protected Klient klient;
    @XmlElement(name = "Avto", required = true)
    protected Avto avto;
    @XmlElement(name = "Tovars", required = true)
    protected Tovars tovars;
    @XmlAttribute(name = "type")
    protected NakladType type;

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link Date }
     *
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link Date }
     *
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * Gets the value of the num property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNum() {
        return num;
    }

    /**
     * Sets the value of the num property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNum(String value) {
        this.num = value;
    }

    /**
     * Gets the value of the seria property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSeria() {
        return seria;
    }

    /**
     * Sets the value of the seria property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSeria(String value) {
        this.seria = value;
    }

    /**
     * Gets the value of the klient property.
     *
     * @return
     *     possible object is
     *     {@link Klient }
     *
     */
    public Klient getKlient() {
        return klient;
    }

    /**
     * Sets the value of the klient property.
     *
     * @param value
     *     allowed object is
     *     {@link Klient }
     *
     */
    public void setKlient(Klient value) {
        this.klient = value;
    }

    /**
     * Gets the value of the avto property.
     *
     * @return
     *     possible object is
     *     {@link Avto }
     *
     */
    public Avto getAvto() {
        return avto;
    }

    /**
     * Sets the value of the avto property.
     *
     * @param value
     *     allowed object is
     *     {@link Avto }
     *
     */
    public void setAvto(Avto value) {
        this.avto = value;
    }

    /**
     * Gets the value of the tovars property.
     *
     * @return
     *     possible object is
     *     {@link Tovars }
     *
     */
    public Tovars getTovars() {
        return tovars;
    }

    /**
     * Sets the value of the tovars property.
     *
     * @param value
     *     allowed object is
     *     {@link Tovars }
     *
     */
    public void setTovars(Tovars value) {
        this.tovars = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link NakladType }
     *
     */
    public NakladType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link NakladType }
     *
     */
    public void setType(NakladType value) {
        this.type = value;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return
            "Naklad{\n" +
            "type=" + type + ", date=" + df.format(date) + ", num='" + num + "', seria='" + seria + "',\n" +
            "klient=" + klient + ",\n" +
            "avto=" + avto + ",\n" +
            "tovars=" + tovars +
            "}";
    }
}
