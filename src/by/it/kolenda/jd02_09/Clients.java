//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.19 at 11:29:31 AM MSK 
//


package by.it.kolenda.jd02_09;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="ClientFL" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Clients")
public class Clients {

    @XmlElement(name = "ClientFL", required = true)
    protected Object clientFL;

    /**
     * Gets the value of the clientFL property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getClientFL() {
        return clientFL;
    }

    /**
     * Sets the value of the clientFL property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setClientFL(Object value) {
        this.clientFL = value;
    }

}
