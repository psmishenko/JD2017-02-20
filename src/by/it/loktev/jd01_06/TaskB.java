package by.it.loktev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void taskB() {

        StringBuilder sb = new StringBuilder(Data.lukomor);

        String glasLetters="аяуюоёэеыиАЯОЁЭЕЫИУЮ";
        Pattern glasGlasPattern = Pattern.compile("^["+glasLetters+"](?:.+["+glasLetters+"])?$"); // слово начинающееся и заканчивающееся гласной

        Pattern wordPattern = Pattern.compile("[а-яА-ЯёЁ]+"); // ищем ВСЕ слова
        Matcher wordMatcher = wordPattern.matcher(sb);
        int glasGlasCount=0;
        while (wordMatcher.find()) {
            String word=wordMatcher.group();
            Matcher glasGlasMatcher = glasGlasPattern.matcher(word);
            if ( glasGlasMatcher.matches() ) {
                //System.out.println(word);
                glasGlasCount++;
            }
        }
        System.out.println("Слов, начинающихся и заканчивающихся на гласную букву: "+glasGlasCount);


    }
}
