package by.it.radivonik.jd02_09.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Klient complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Klient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Unp" type="{http://generate.beans.jd02_09.radivonik.it.by}Unp"/>
 *         &lt;element name="Adres" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Klient", propOrder = {
        "name",
        "unp",
        "adres"
})
public class Klient {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Unp", required = true)
    protected String unp;
    @XmlElement(name = "Adres", required = true)
    protected String adres;

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
     * Gets the value of the unp property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnp() {
        return unp;
    }

    /**
     * Sets the value of the unp property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnp(String value) {
        this.unp = value;
    }

    /**
     * Gets the value of the adres property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAdres() {
        return adres;
    }

    /**
     * Sets the value of the adres property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAdres(String value) {
        this.adres = value;
    }

    @Override
    public String toString() {
        return "Klient{name='" + name + "', unp='" + unp + "', adres='" + adres + "'}";
    }
}
