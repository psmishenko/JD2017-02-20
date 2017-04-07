package by.it.smirnov.jd02_05;

import java.text.DateFormat;
import java.util.*;

/**
 * Created by aleksey.smirnov on 07.04.2017.
 */
public class Hello {
    static enum Locales {
        ru, be, en
    }
    public static void main(String[] args) {
        // Вариант A
        if (args.length==2) {
            Locale locale=new Locale(args[0], args[1]);
            Language.changeLocal(locale);
        }
        System.out.println(Language.getString(IMessages.WELCOME));
        System.out.println(Language.getString(IMessages.MYNAME));
        System.out.println(Language.getString(IMessages.HOWDOYOUDO));
        System.out.println();

        // Вариант B
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Language.getLocale());
        System.out.print(Language.getString(IMessages.CURRENTDATE)+": ");
        System.out.println(df.format(new Date()));
        System.out.println();

        // Вариант С
        Set<String> listLocales = new HashSet<String>(){{
            add("ru"); add("RU");
            add("be"); add("BE");
            add("en"); add("EN");
        }};
        while (true) {
            System.out.print(Language.getString(IMessages.ENTERLOCALE)+": ");
            String strLocale = new Scanner(System.in).nextLine();
            if (strLocale.equalsIgnoreCase("quit")) {
                break;
            } else {
                if (listLocales.contains(strLocale)) {
                    Locale localeNew = new Locale(strLocale);
                    Language.changeLocal(localeNew);
                    System.out.println(Language.getString(IMessages.WELCOME));
                    System.out.println(Language.getString(IMessages.MYNAME));
                    System.out.println(Language.getString(IMessages.HOWDOYOUDO));
                    DateFormat dfLocal = DateFormat.getDateInstance(DateFormat.FULL, localeNew);
                    System.out.print(Language.getString(IMessages.CURRENTDATE)+": ");
                    System.out.println(dfLocal.format(new Date()));
                } else {
                    System.err.println(Language.getString(IMessages.ERRORLOCALE));
                }
            }
            System.out.println();
        }
    }
}
