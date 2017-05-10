package by.it.zeynalov.jd02_05.HomeWork;

import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        ResourceBundle bundleDefault = ResourceBundle.getBundle("by.it.zeynalov.jd02_05.HomeWork.language");
        ResourceBundle bundleDefault1 = ResourceBundle.getBundle("by.it.zeynalov.jd02_05.HomeWork.language", new Locale("ru", "RU"));
        ResourceBundle bundleDefault2 = ResourceBundle.getBundle("by.it.zeynalov.jd02_05.HomeWork.language", new Locale("en", "USA"));

        System.out.println(bundleDefault.getString("welcome"));
        System.out.println(bundleDefault1.getString("welcome"));
        System.out.println(bundleDefault2.getString("welcome"));
    }
}
