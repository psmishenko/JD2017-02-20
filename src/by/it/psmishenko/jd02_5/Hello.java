package by.it.psmishenko.jd02_5;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 07.04.2017.
 */
public class Hello {
    public static void main(String[] args) {
        if(args.length==2) {
            Locale locale = new Locale(args[0],args[1]);
        Language.changeLocale(locale);
        }
        System.out.println(Language.getString(Message.HOWDOYOUDO));
        System.out.println(Language.getString(Message.MYNAME));
        System.out.println(Language.getString(Message.WELCOME));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        String sDate = dateFormat.format(date);
        System.out.println(sDate);
    }
}
