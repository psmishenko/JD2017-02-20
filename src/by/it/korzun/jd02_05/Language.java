package by.it.korzun.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class Language {
    private static String path = "by.it.korzun.jd02_05.messages";
    private static Locale locale = Locale.ENGLISH;

    static Locale getLocale() {
        return locale;
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(
            path, locale
    );

    static void changeLocale(Locale localeIn){
        locale = localeIn;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    static String getString(String key){
        return resourceBundle.getString(key);
    }
}
