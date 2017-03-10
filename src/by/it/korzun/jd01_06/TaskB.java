package by.it.korzun.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static int checkGlasn(String[] words){
        Pattern patternLong = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯ](.)*[аеёиоуыэюяАЕЁИОУЫЭЮЯ]");
        Pattern patternOne = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯ]");
        Matcher matcher;
        int count = 0;
        for (String word : words) {
            if (word.length() > 1) {
                matcher = patternLong.matcher(word);
            } else {
                matcher = patternOne.matcher(word);
            }
            if (matcher.matches()) {
                count++;
            }
        }
        return count;
    }
    static void run(){
        System.out.println("TaskB:\n1.------------------------------------------");
        String[] words = Data.lukomor.split("[^а-яА-ЯеЁ]+");
        System.out.println("Количество подходящих слов: " + checkGlasn(words));

        System.out.println("2.------------------------------------------");
        String s = Data.lukomor;
        s = s.replaceAll("\\p{Cntrl}", " ");
        String[] sentences = s.split("[.!?;] ");

        sentences = Util06.sort(sentences);
        for (String sk:sentences) {
            sk = sk.trim();
            System.out.println(sk);
        }
    }
}
