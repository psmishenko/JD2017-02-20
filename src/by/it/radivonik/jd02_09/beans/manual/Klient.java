package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Klient")
public class Klient {
    @XmlElement(name = "Name", required = true)
    private String name;
    @XmlElement(name = "Unp", required = true)
    private String unp;
    @XmlElement(name = "Adres", required = true)
    private String adres;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getUnp() {
        return unp;
    }

    public void setUnp(String value) {
        this.unp = value;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String value) {
        this.adres = value;
    }

    @Override
    public String toString() {
        return "Klient{name='" + name + "', unp='" + unp + "', adres='" + adres + "'}";
    }
}
