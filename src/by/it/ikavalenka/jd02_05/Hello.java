package by.it.ikavalenka.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by USER on 07.04.2017.
 */
public class Hello {
    public static void main(String[] args) {
        if (args.length>=2) {
            Locale locale = new Locale(args[0], args[1]);
            Languages.changeLocal(locale);
        }
//        Locale locale = new Locale("by","BY");
        System.out.println(Languages.getString(IMessage.HOWDOYOUDO));
        System.out.println(Languages.getString(IMessage.MYNAME));
        System.out.println(Languages.getString(IMessage.WELCOME));
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("JD_01_2017_03/jd02_05/messages",new Locale("ru","RU"));
//        System.out.println(resourceBundle.getString(IMessage.HOWDOYOUDO));

        Date d =new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Languages.getLocale());
        String sDate = dateFormat.format(d);

        System.out.println(sDate);
    }
}
