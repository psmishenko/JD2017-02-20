package by.it.radivonik.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class Language {
    private static String path = "by.it.radivonik.jd02_05.messages";
    private static Locale locale = new Locale("en","US");
    static ResourceBundle resourceBundle = ResourceBundle.getBundle(path,locale);

    static void changeLocale(Locale localeNew) {
        locale = localeNew;
        resourceBundle = ResourceBundle.getBundle(path,locale);
    }

    static String getString(String key) {
        return resourceBundle.getString(key);
    }

    public static Locale getLocale() {
        return locale;
    }
}
