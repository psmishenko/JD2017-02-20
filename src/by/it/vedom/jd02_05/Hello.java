package by.it.vedom.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Hello {

    public static void main(String[] args) {
        if(args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeBundle(locale);
        }
        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.MYNAME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.TODAY));

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Language.getLocale());
        String sDate = dateFormat.format(date);

        System.out.println(sDate);
    }
}
