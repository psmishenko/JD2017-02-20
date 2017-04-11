package by.it.prigozhanov.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public class Language {

    private static String path = "by.it.prigozhanov.jd02_05.resources.message";

    private static Locale locale = new Locale("en", "US");
    private String language;
    static ResourceBundle resourceBundle = ResourceBundle.getBundle(path, locale);

    static String getDate() {
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Language.getLocale());
        return df.format(date);
    }

   static void setLanguage(String language) {
            language = language;
                switch (language) {
                    case "en":
                        locale = new Locale("en", "US");
                        resourceBundle = ResourceBundle.getBundle(path, locale);
                        break;
                    case "ru":
                        locale = new Locale("ru", "RU");
                        resourceBundle = ResourceBundle.getBundle(path, locale);
                        break;
                    case "be":
                        locale = new Locale("be", "BY");
                        resourceBundle = ResourceBundle.getBundle(path, locale);
                        break;
                    default:
                        locale = new Locale("en", "US");
                        resourceBundle = ResourceBundle.getBundle(path, locale);
                        break;
                }
    }

    public static Locale getLocale() {
        return locale;
    }
}
