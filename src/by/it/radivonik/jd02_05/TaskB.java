package by.it.radivonik.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class TaskB {
    public void run(String[] args) {
        if (args.length >= 2)
            Language.changeLocale(new Locale(args[0],args[1]));

        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        System.out.println(df.format(d));
    }
}
