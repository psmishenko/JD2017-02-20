package by.it.sorokoee.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        if (args.length==2){
            Locale locale=new Locale(args[0],args[1]);
            Language.changeLocal(locale);
        }

        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));
        Date d=new Date();
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        String sDate=dateFormat.format(d);
        System.out.println(Language.getString(Messages.NOW)+": "+sDate);
        System.out.println();


        Language.changeLocal(new Locale("be","BY"));
        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));
        Date d1=new Date();
        DateFormat dateFormat1=DateFormat.getDateInstance(DateFormat.LONG,Language.getLocale());
        String sDate1=dateFormat1.format(d1);
        System.out.println(Language.getString(Messages.NOW)+": "+sDate1);


    }

}
