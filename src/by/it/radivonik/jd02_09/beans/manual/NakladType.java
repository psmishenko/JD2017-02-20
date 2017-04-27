package by.it.radivonik.jd02_09.beans.manual;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Radivonik on 23.04.2017.
 */
@XmlType(name = "NakladType")
@XmlEnum
public enum NakladType {
    TN_IN, TTN_IN, TN_OUT, TTN_OUT;
}
