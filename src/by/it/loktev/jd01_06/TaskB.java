package by.it.loktev.jd01_06;

import java.util.Arrays;
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
        System.out.println("Слов, начинающихся и заканчивающихся на гласную букву: "+glasGlasCount+"\n\n");

        // получим предложения
        Pattern phrasesSplitPattern = Pattern.compile("[\\.!?]+ *");
        String [] phrases=phrasesSplitPattern.split(Data.lukomor);
        String [] sortPhrases=new String[phrases.length];
        for ( int i=0; i<phrases.length; i++ ) {
            String phrase=phrases[i].replace("\n"," ").trim(); // уберём переносы строк и лишние пробелы на концах
            String [] phraseWords=phrase.split("[^а-яА-ЯёЁ]+");
            System.out.println("Слов: "+phraseWords.length+", предложение:");
            System.out.println(phrase);
            sortPhrases[i]=String.format("%05d",phraseWords.length)+phrase; // дописываем слева к предложению кол-во слов в нём фиксированной длины - для простоты сортировки, раз уж мы не умеем ничего другого
        }

        Arrays.sort(sortPhrases);

        System.out.println("\nПредложения, отсортированные по количеству слов:");
        for ( String phrase : sortPhrases )
            System.out.println(phrase.substring(5));


    }
}
