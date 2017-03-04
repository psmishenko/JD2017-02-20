package by.it.prigozhanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/3/2017.
 * ауоыиэяюёеАУОЫИЭЯЮЁЕ
 */
public class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Data.lukomor);
        Pattern wordpattern = Pattern.compile("[^а-яА-ЯёЁ]+"); // pattern на нахождение отдельных слов
        Pattern pattern = Pattern.compile("[ауоыиэяюёеАУОЫИЭЯЮЁЕ]{1,}");
        String[] sb1 = wordpattern.split(sb);
        Matcher matcher = wordpattern.matcher(sb);
        for (int i = 0; i < sb1.length; i++) {
            Matcher matcher1 = pattern.matcher(sb1[i]);
            System.out.println(matcher1.group());
        }
    }
}
