package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tovars")
public class Tovars {
    @XmlElement(name = "Tovar", required = true)
    private List<Tovar> tovar;

    public List<Tovar> getTovar() {
        if (tovar == null) {
            tovar = new ArrayList<Tovar>();
        }
        return this.tovar;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Tovars{");
        String delim = "";
        for (Tovar tovar:  getTovar()) {
            res.append(delim).append("\n").append(tovar);
            delim = ",";
        }
        res.append("}");
        return res.toString();
    }
}
