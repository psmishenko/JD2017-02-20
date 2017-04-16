package by.it.Zyryanov.jd02_05.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


public class Task_5  {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter preferred language:\n ru - for Russian \n be - for Belorussian \n de = for German");
        String readLanguage = reader.readLine();

        String readLocale = "";

        if (readLanguage.contentEquals("be")){
            readLocale = "BY";
        } else if (readLanguage.contentEquals("de")){
            readLocale = "DE";
        } else if (readLanguage.contentEquals("ru")) {
            readLocale = "RU";
        }
        Locale locale = new Locale(readLanguage, readLocale);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.Zyryanov.jd02_05.homework.m2", locale);

        Date now = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);

        System.out.println(resourceBundle.getString("Main.greetings") + "\n" + dateFormat.format(now));
    }
}
