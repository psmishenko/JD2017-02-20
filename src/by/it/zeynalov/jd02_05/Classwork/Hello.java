package by.it.zeynalov.jd02_05.Classwork;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Hello {
    public static void main(String[] args) {
        if (args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeLocal(locale);
        }
        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));

        Date d = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Language.getLocale());
        String sDate = dateFormat.format(d);
        System.out.println(sDate);
    }
}
