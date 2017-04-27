package by.it.radivonik.jd02_09.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Avto complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Avto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumGos" type="{http://generate.beans.jd02_09.radivonik.it.by}NumAvto"/>
 *         &lt;element name="Voditel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Avto", propOrder = {
        "numGos",
        "voditel"
})
public class Avto {

    @XmlElement(name = "NumGos", required = true)
    protected String numGos;
    @XmlElement(name = "Voditel", required = true)
    protected String voditel;

    /**
     * Gets the value of the numGos property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumGos() {
        return numGos;
    }

    /**
     * Sets the value of the numGos property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumGos(String value) {
        this.numGos = value;
    }

    /**
     * Gets the value of the voditel property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVoditel() {
        return voditel;
    }

    /**
     * Sets the value of the voditel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVoditel(String value) {
        this.voditel = value;
    }

    @Override
    public String toString() {
        return "Avto{numGos='" + numGos + "', voditel='" + voditel + "'}";
    }
}