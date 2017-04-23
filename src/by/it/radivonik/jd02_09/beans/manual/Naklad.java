package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Naklad")
public class Naklad {
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    private Date date;
    @XmlElement(name = "Num", required = true)
    private String num;
    @XmlElement(name = "Seria", required = true)
    private String seria;
    @XmlElement(name = "Klient", required = true)
    private Klient klient;
    @XmlElement(name = "Avto", required = true)
    private Avto avto;
    @XmlElement(name = "Tovars", required = true)
    private Tovars tovars;
    @XmlAttribute(name = "type")
    private NakladType type;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String value) {
        this.num = value;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String value) {
        this.seria = value;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient value) {
        this.klient = value;
    }

    public Avto getAvto() {
        return avto;
    }

    public void setAvto(Avto value) {
        this.avto = value;
    }

    public Tovars getTovars() {
        return tovars;
    }

    public void setTovars(Tovars value) {
        this.tovars = value;
    }

    public NakladType getType() {
        return type;
    }

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
