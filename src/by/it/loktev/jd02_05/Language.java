package by.it.loktev.jd02_05;

import java.text.DateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static final String path="by.it.loktev.jd02_05.messages";
    private static Locale locale;
    public static ResourceBundle resourceBundle;

    static {
        changeLocale(Locale.US);
    }

    static void changeLocale(Locale locale_){
        locale=locale_;
        resourceBundle=ResourceBundle.getBundle(path,locale);
    }

    static String getString(String key){
        return resourceBundle.getString(key);
    }

    static DateFormat getDateFormat(){
        return DateFormat.getDateInstance(DateFormat.LONG,locale);
    }

}
