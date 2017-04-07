package by.it.loktev.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static final String path="by.it.loktev.jd02_05.messages";
    private static Locale locale=Locale.US; //new Locale("be","BY");
    public static ResourceBundle resourceBundle=ResourceBundle.getBundle(path,locale);

    static void changeLocale(Locale locale_){
        locale=locale_;
        resourceBundle=ResourceBundle.getBundle(path,locale);
    }

    static String getString(String key){
        return resourceBundle.getString(key);
    }

}
