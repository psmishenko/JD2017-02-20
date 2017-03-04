package by.it.prigozhanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/3/2017.
 */
public class TaskB {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Data.lukomor);
        Pattern pattern = Pattern.compile("[ауоыиэяюёеАУОЫИЭЯЮЁЕ]");
        String[] sb1 = pattern.split(sb);
        Matcher matcher = pattern.matcher(sb);

        int end = sb.length();
        while (matcher.find()) {
            System.out.print(matcher.group());
        }
    }
}
