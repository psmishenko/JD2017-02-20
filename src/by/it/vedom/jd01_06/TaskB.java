package by.it.vedom.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static int optionB1 () {

        //В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(equalElements(word))
            count++;
        }
        return count;
    }

    /**
     *
     * @param word входное слово
     * @return результат сравнения
     */
    private static boolean equalElements (String word) {
        String str = "ауоыиэяюёеАУЫИЭЯЮЁЕ";
        if (word.isEmpty()) return false;
                Character firstSymbol = word.charAt(0);
                Character lastSymbol = word.charAt(word.length()-1);
                Pattern pattern1 = Pattern.compile(firstSymbol.toString());
                Pattern pattern2 = Pattern.compile(lastSymbol.toString());
                Matcher matcher1 = pattern1.matcher(str);
                Matcher matcher2 = pattern2.matcher(str);
                return (matcher1.find() && matcher2.find());
    }


    //Вывести все предложения в порядке возрастания количества слов. Убрать переносы слов.
    public static void optionB2 () {
        Pattern pattern = Pattern.compile("[.!?]+");
        String [] str = pattern.split(Data.lukomor);
        String [] sortStr = new String[str.length];
        for ( int i = 0; i < str.length; i++ ) {
            String change = str[i].replaceAll("\n"," ").trim();
            String [] words = change.split("[^а-яА-ЯёЁ]+");
            System.out.println(change);
            System.out.println("В данном предложении "+words.length+ " слов.");
            sortStr[i] = String.format("%3d",words.length)+change;
            System.out.println();
        }
        Arrays.sort(sortStr);

        System.out.println("Отсортирвоанные предложения в порядке возрастания: ");
        for (int i = 0; i < sortStr.length; i++) {
            System.out.println(sortStr[i].substring(3));
        }
    }

}
