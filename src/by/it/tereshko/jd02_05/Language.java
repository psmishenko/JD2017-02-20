package by.it.tereshko.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {

    private static String path = "by.it.tereshko.jd02_05.messages";

    private static Locale locale = Locale.getDefault();
//    private static Locale locale = new Locale("be","BY");
//    private static Locale locale = new Locale("ru","RU");
//    private static Locale locale = new Locale("en","EN");
//    private static Locale locale = Locale.US;

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
