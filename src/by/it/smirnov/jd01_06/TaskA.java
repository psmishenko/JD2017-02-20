package by.it.smirnov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 03.03.2017.
 */
public class TaskA {
    public static void run() {
        StringBuilder sb = new StringBuilder(Data.lukomor);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher=pattern.matcher(sb);
        while (matcher.find()) {
            //sb.replace(matcher.start()+3,matcher.start()+4,"#");
            sb.setCharAt(matcher.start()+3, '#');
            if (matcher.group().length()>=7)
                sb.setCharAt(matcher.start()+6, '#');
            //sb.replace(matcher.start()+6,matcher.start()+7,"#");
        }
        System.out.println(sb);

        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        //System.out.print(Arrays.toString(words));
        System.out.println();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int counter = 0;
            if (!word.isEmpty()) {
                for (int j = i+1; j < words.length; j++) {
                    if (word.equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                }
                System.out.printf("Слово \"%s\" повторяется %d раз\n",word, counter);
            }
        }
    }
}
