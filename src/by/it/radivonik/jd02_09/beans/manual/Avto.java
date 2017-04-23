package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Avto")
public class Avto {
    @XmlElement(name = "NumGos", required = true)
    private String numGos;
    @XmlElement(name = "Voditel", required = true)
    private String voditel;

    public String getNumGos() {
        return numGos;
    }

    public void setNumGos(String value) {
        this.numGos = value;
    }

    public String getVoditel() {
        return voditel;
    }

    public void setVoditel(String value) {
        this.voditel = value;
    }

    @Override
    public String toString() {
        return "Avto{numGos='" + numGos + "', voditel='" + voditel + "'}";
    }
}
