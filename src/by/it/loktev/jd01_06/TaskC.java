package by.it.loktev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    public static void taskC() {

        StringBuilder sb = new StringBuilder(Data.lukomor);

        // получим строки, посчитаем длину самой длинной
        Pattern linesSplitPattern = Pattern.compile("[\\n]+");
        String [] lines=linesSplitPattern.split(Data.lukomor);

        int maxLength=0;
        for ( int i=0; i<lines.length; i++ ) {
            String line=lines[i];
            //System.out.println("Строка: "+line);
            maxLength=Math.max(maxLength,line.length());
            /*
            String [] phraseWords=phrase.split("[^а-яА-ЯёЁ]+");
            System.out.println("Слов: "+phraseWords.length+", предложение:");
            System.out.println(phrase);
            sortPhrases[i]=String.format("%05d",phraseWords.length)+phrase; // дописываем слева к предложению кол-во слов в нём фиксированной длины - для простоты сортировки, раз уж мы не умеем ничего другого
            */
        }
        System.out.println("Длина самой длинной строки: "+maxLength);

        System.out.println("\n\nТекст, выровненный по ширине:");

        // расставляем пробелы
        Pattern wordsSplitPattern = Pattern.compile(" +");
        for ( int i=0; i<lines.length; i++ ) {
            String line=lines[i];
            //System.out.println("Строка: "+line);
            int leftBlanksToAdd=maxLength-line.length(); // сколько пробелов надо ещё добавить в эту строку
                //System.out.println("Добавляем пробелов: " + leftBlanksToAdd);
                // разобьём строку на слова
                String[] words = wordsSplitPattern.split(line);
                //System.out.println("Слова: " + Arrays.toString(words));
                int leftSpacesToExpand = words.length - 1; // сколько ещё мест для вставки пробелов осталось в этой строке
                String formattedLine = words[0];
                for (int w = 1; w < words.length; w++) {
                    // сколько пробелов надо вставить в это место?
                    int blanksToInsert = (int) Math.round(leftBlanksToAdd / (double) leftSpacesToExpand); // важно именно round, иначе пробелы будут добавляться не так равномерно
                    if ( blanksToInsert>0 ) {
                        formattedLine += String.format("%" + blanksToInsert + "s", "");
                        leftBlanksToAdd -= blanksToInsert;
                    }
                    leftSpacesToExpand--;
                    formattedLine += " " + words[w];
                }
            System.out.println(formattedLine);
        }

    }
}
