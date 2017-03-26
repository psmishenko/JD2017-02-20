package by.it.sorokoee.jd01_06.levelB;

import by.it.sorokoee.jd01_06.Data;
import by.it.sorokoee.jd01_06.levelA.TaskA;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static boolean glasnaya(String word) {
        boolean a = true;
        String aei = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return (aei.indexOf(first) >= 0 && aei.indexOf(last) >= 0);
    }

    public static void summaWords(String text) {
        StringBuilder tx = new StringBuilder(text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(tx);
        int count = 0;
        while (m.find())
            if (glasnaya(m.group())) {
                if (m.group().length() > 1) {
                    count++;
                    System.out.println("слово, начинающиеся и заканчивающиеся на гласную:" + m.group());
                }
            }
        if (count > 0) {
            System.out.println("количество слов начинающихся и заканчивающихся на гласную=" + count);
        } else {
            System.out.println("Таких слов не существует");
        }
    }

    public static void sortPredlozh() {
//        String text = Data.lukomor.replaceAll("\n", " ");
        String[] stroki = Data.lukomor.replaceAll("\n", " ").split("[.!?]+ ");
        int [] lenStroki=new int[stroki.length];
        for (int i = 0; i < stroki.length; i++) {
//            String[] slova = stroki[i].split(" ");
            lenStroki[i]=stroki[i].split(" ").length;
//            System.out.println(slova.length);
        }
    }
}



