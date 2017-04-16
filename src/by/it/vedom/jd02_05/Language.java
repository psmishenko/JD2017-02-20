package by.it.vedom.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static String path = "by.it.vedom.jd02_05.messages";

    public static Locale getLocale() {
        return locale;
    }

    private static Locale locale= new Locale("en", "EN");

    static ResourceBundle resourceBundle = ResourceBundle.getBundle(path, locale);

    static void changeBundle(Locale localeIn) {
        locale = localeIn;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
