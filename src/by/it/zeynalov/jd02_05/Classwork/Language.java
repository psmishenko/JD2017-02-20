package by.it.zeynalov.jd02_05.Classwork;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static String path = "by.it.zeynalov.jd02_05.classwork.messages";
    private static Locale locale = Locale.getDefault();

    public static Locale getLocale() {
        return locale;
    }

    static ResourceBundle resourceBundle = ResourceBundle.getBundle(path, locale);

    static void changeLocal(Locale localeIn) {
        locale = localeIn;
        resourceBundle = ResourceBundle.getBundle(path, locale);
    }

    static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
