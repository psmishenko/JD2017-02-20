package by.it.prigozhanov.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String language = null;
        while (true) {
            if (args.length == 2) {
                Language.setLanguage(args[0]);
            } else {
                System.out.println(Language.resourceBundle.getString(Message.ENTER));
                language = reader.readLine();
                Language.setLanguage(language);
            }



            System.out.println(Language.resourceBundle.getString(
                    Message.GREETINGS) + " " + " " +
                    Language.resourceBundle.getString(Message.NAME) + ", " +
                    Language.resourceBundle.getString(Message.TODAY) + " " +
                    Language.getDate()
            );
            if (args.length == 2) break;
            if (language.equals("close")) break;
        }
    }
}
