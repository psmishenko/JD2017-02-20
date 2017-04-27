package by.it.radivonik.jd02_09.beans;

import java.util.ArrayList;
import java.util.List;
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
 *       &lt;sequence>
 *         &lt;element name="Naklad" type="{http://generate.beans.jd02_09.radivonik.it.by}Naklad" maxOccurs="unbounded"/>
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
        "naklad"
})
@XmlRootElement(name = "Naklads")
public class Naklads {

    @XmlElement(name = "Naklad", required = true)
    protected List<Naklad> naklad;

    /**
     * Gets the value of the naklad property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the naklad property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNaklad().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Naklad }
     *
     *
     */
    public List<Naklad> getNaklad() {
        if (naklad == null) {
            naklad = new ArrayList<Naklad>();
        }
        return this.naklad;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Naklads{");
        String delim = "";
        for (Naklad naklad:  getNaklad()) {
            res.append(delim).append("\n").append(naklad);
            delim = ",";
        }
        res.append("}");
        return res.toString();
    }
}
