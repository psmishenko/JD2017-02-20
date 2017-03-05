package by.it.radivonik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Radivonik on 03.03.2017.
 */
public class TaskA {
    public static void zad1() {
        StringBuilder s = new StringBuilder(Data.lukomor);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher m = p.matcher(s);
        int pos;

        while (m.find()) {
            //System.out.println(m.group());
            //s.replace(m.start()+3,m.start()+4,"#");
            pos = m.start() + 3;
            s.setCharAt(pos,'#');
            if (m.group().length() >= 7) {
                //s.replace(m.start() + 6, m.start() + 7, "#");
                pos = m.start() + 6;
                s.setCharAt(pos,'#');
            }
        }
        System.out.println(s);
    }

    public static void zad2() {
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int c = 1;
            if (!w.isEmpty()) {
                for (int j = i+1; j < words.length; j++) {
                    if (w.equalsIgnoreCase(words[j])) {
                        c++;
                        words[j] = "";
                    }
                }
                System.out.printf("\nСлово '%s' повторяется %d раз",w,c);
            }
        }
    }
}
