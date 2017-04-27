package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Naklads")
public class Naklads {
    @XmlElement(name = "Naklad", required = true)
    protected List<Naklad> naklad;

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
