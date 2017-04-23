package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tovar")
public class Tovar {
    @XmlElement(name = "Name", required = true)
    private String name;
    @XmlElement(name = "EdIzm", required = true)
    private String edIzm;
    @XmlElement(name = "Count", required = true)
    private double count;
    @XmlElement(name = "Cena", required = true)
    private double cena;
    @XmlElement(name = "Stoim", required = true)
    private double stoim;
    @XmlElement(name = "PrNds", required = true)
    private double prNds;
    @XmlElement(name = "Nds", required = true)
    private double nds;
    @XmlElement(name = "StoimPoln", required = true)
    private double stoimPoln;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getEdIzm() {
        return edIzm;
    }

    public void setEdIzm(String value) {
        this.edIzm = value;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double value) {
        this.count = value;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double value) {
        this.cena = value;
    }

    public double getStoim() {
        return stoim;
    }

    public void setStoim(double value) {
        this.stoim = value;
    }

    public double getPrNds() {
        return prNds;
    }

    public void setPrNds(double value) {
        this.prNds = value;
    }

    public double getNds() {
        return nds;
    }

    public void setNds(double value) {
        this.nds = value;
    }

    public double getStoimPoln() {
        return stoimPoln;
    }

    public void setStoimPoln(double value) {
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
