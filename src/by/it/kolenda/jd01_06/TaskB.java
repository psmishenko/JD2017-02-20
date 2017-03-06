package by.it.kolenda.jd01_06;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class TaskB {


    private static boolean glasnaya(String word){
        final String GLAS="аяоёэеиуюыАЯОЁЭЕИУЮЫ";

        Character f=word.charAt(0);
        Character l=word.charAt(word.length()-1);
        Pattern pf=Pattern.compile(f.toString());
        if (!GLAS.contains(f.toString()) || !GLAS.contains(l.toString()))
            return false;

        return true;
    }

    public static void main(String[] args) {

        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        Pattern pattern = Pattern.compile("[аяоёэеиую]");
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (glasnaya(word) == true) {

                counter++;
            }

        }
        System.out.printf("Слов с гласными в начале и конце - %d", counter);

    }
}