package by.it.psmishenko.jd02_5;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 07.04.2017.
 */
public class Language {
    static private Locale locale= Locale.getDefault();
    static private String path = "by.it.psmishenko.jd02_5.message";
   static ResourceBundle resourceBundle = ResourceBundle.getBundle(path,locale);

    public static Locale getLocale() {
        return locale;
    }

    static  void changeLocale(Locale localeIn){
        locale = localeIn;
      resourceBundle = ResourceBundle.getBundle(path,locale);
    }
    static String getString(String key){
        return resourceBundle.getString(key);
    }
}
