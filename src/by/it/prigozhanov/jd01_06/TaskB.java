package by.it.prigozhanov.jd01_06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/3/2017.
 * ауоыиэяюёеАУОЫИЭЯЮЁЕ
 */
public class TaskB {


    private static boolean firstAndLastCharCheck(String s) {
        Pattern pattern = Pattern.compile("[ауоыиэяюёеАУОЫИЭЯЮЁЕ]");
        Character firstChar = s.charAt(0);
        Character lastChar = s.charAt(s.length() - 1);
        Matcher matchfirst = pattern.matcher(firstChar.toString());
        Matcher matchlast = pattern.matcher(lastChar.toString());
        if (!matchfirst.find()) {
            return false;
        }
        if (!matchlast.find()) {
            return false;
        }

        return true;

    }

    static void sentenseSort(int[] a, String[][] s) {
        boolean swap;
        int last = a.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (a[i] > a[i+1]) {
                    String buffStr = s[i][0];
                    s[i][0] = s[i + 1][0];
                    s[i + 1][0] = buffStr;
                    int buffInt = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buffInt;
                    swap = true;

                }
            }
            last--;
        } while (swap);
    }

    public static void main(String[] args) {
        //задание 1
        StringBuilder sb = new StringBuilder(Data.lukomor);
        int counter = 0;
        Pattern wordpattern = Pattern.compile("[^а-яА-ЯёЁ]+"); // pattern на нахождение отдельных слов
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < words.length; i++) {
            if (firstAndLastCharCheck(words[i])) {
                counter++;
            }
        }
        System.out.println("Колличество слов начинающихся и заканчивающихся на согласные = " + counter);

        //задание 2
        int pos;
        Pattern linedown = Pattern.compile("\n");
        Pattern pt = Pattern.compile("[а-яА-ЯёЁ\\s\\-\\:\\,]+");
        String[] sentenses = Data.lukomor.split("[\\.\\;\\!]+");
        String[][] strarr = new String[sentenses.length][1];
        int[] wordsCountArr = new int[sentenses.length];
        for (int i = 0; i < sentenses.length; i++) {
            Matcher match = pt.matcher(sentenses[i]);
            Matcher line = linedown.matcher(sentenses[i]);
            StringBuilder linesb = new StringBuilder(sentenses[i]);
            while (match.find()) {
                while (line.find()) {
                    pos = line.start();
                    linesb.setCharAt(pos, ' ');
                }
                strarr[i][0] = linesb.toString().trim();
                wordsCountArr[i] = strarr[i][0].split("[^а-яА-ЯёЁ]+").length;
            }
        }
        sentenseSort(wordsCountArr, strarr);
        for (int i = 0; i < sentenses.length; i++) {
            System.out.print("[" + wordsCountArr[i] + "] ");
            System.out.println(strarr[i][0]);
        }

    }


}
