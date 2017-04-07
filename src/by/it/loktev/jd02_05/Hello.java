package by.it.loktev.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {

    public static void main(String[] args) {

        if (args.length==2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeLocale(locale);
        }

        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));

        DateFormat df=Language.getDateFormat();
        System.out.println(df.format(new Date()));
    }

}
