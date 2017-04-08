package by.it.kolenda.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) {
        if (args.length==2){


        Locale locale = new Locale(args[0],args[1]);
        Language.changeLocal(locale);
        }
        System.out.println(Language.getString(Message.WELCOME));
        System.out.println(Language.getString(Message.HOWDOYUODO));
        System.out.println(Language.getString(Message.MYNAME));

        Date d=new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Language.getLocale());
    }
}
