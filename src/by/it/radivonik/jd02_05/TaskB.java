package by.it.radivonik.jd02_05;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class TaskB {
    public void run() {
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        System.out.println(df.format(d));
    }
}
