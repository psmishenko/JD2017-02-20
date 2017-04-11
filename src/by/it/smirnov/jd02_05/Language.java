package by.it.smirnov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by aleksey.smirnov on 07.04.2017.
 */
public class Language {
    private static String path = "by.it.smirnov.jd02_05.res.messages";
    private static Locale locale = Locale.US;
    static ResourceBundle resourceBundle;
    static {
        changeLocal(locale);
    }

    static void changeLocal(Locale localeIn){
        locale = localeIn;
        resourceBundle = ResourceBundle.getBundle(path,locale);
    }

    public static Locale getLocale() {
        return locale;
    }

    static String getString(String key) {
        return resourceBundle.getString(key);
    }
}
