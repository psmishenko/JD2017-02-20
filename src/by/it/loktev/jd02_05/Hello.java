package by.it.loktev.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {

    public static void main(String[] args) {
        //ResourceBundle resourceBundle=ResourceBundle.getBundle("by.it.loktev.jd02_05.messages",new Locale("ru","RU"));
        if (args.length==2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeLocale(locale);
        }
        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));

       // Date d=new Date();
       // DateFormat df=DateFormat.get
    }

}
