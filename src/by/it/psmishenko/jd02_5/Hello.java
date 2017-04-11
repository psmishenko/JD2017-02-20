package by.it.psmishenko.jd02_5;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 07.04.2017.
 */
public class Hello {
    static void text(){
        System.out.println(Language.getString(Message.HOWDOYOUDO));
        System.out.println(Language.getString(Message.MYNAME));
        System.out.println(Language.getString(Message.WELCOME));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        String sDate = dateFormat.format(date);
        System.out.println(sDate);
    }
    public static void main(String[] args) {
        if(args.length==2) {
            Locale locale = new Locale(args[0],args[1]);
        Language.changeLocale(locale);
        }
        text();
        boolean zxc = true;
        do {
            System.out.println(Language.getString(Message.EnterLang));
            String lang = new Scanner(System.in).nextLine();
            switch (lang){
                case "ru":
                    Locale locale = new Locale("ru","RU");
                    Language.changeLocale(locale);
                    text();
                    break;
                case "be":
                    Locale locale1 = new Locale("be","BY");
                    Language.changeLocale(locale1);
                    text();
                    break;
                case "en":
                    Locale locale2 = Locale.getDefault();
                    Language.changeLocale(locale2);
                    text();
                    break;
                default: zxc = false;
            }
        }while (zxc);
    }
}
