package by.it.ikavalenka.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by USER on 07.04.2017.
 */
public class Languages {
    private  static  String path = "JD_01_2017_03.jd02_05.messages";
//    private static Locale locale = new Locale("ru","RU");
private static Locale locale = Locale.US;
        public static Locale getLocale(){
            return locale;
        }

     static ResourceBundle resourceBundle = ResourceBundle.getBundle("JD_01_2017_03/jd02_05/messages",new Locale("ru","RU"));
        static void changeLocal(Locale localeIn){
            locale=localeIn;
            resourceBundle =ResourceBundle.getBundle(path,locale);
        }
        static String getString (String key){
            return resourceBundle.getString(key);
        }
}
