package by.it.zeynalov.jd01_06.Level_A;

import static by.it.zeynalov.jd01_06.Level_A.Data.lukomor;

public class TaskC {

    //считаем время генерации миллиона символов
    public static void optionC() {
        String[] words2 = lukomor.split("[\\n\\s\\p{Punct}]");
        int nLen = 1000000;
        String longWord = "";
        long time = System.currentTimeMillis();
        while (longWord.length() < nLen) {
            int e = (int) (Math.random() * words2.length);
            if (longWord.length() + words2[e].length() <= nLen) longWord += words2[e];
            // System.out.println(longWord.length());
        }
        System.out.println("String time: " + (System.currentTimeMillis() - time));

        long timeSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1000000);
        while (sb.length() < nLen) {
            int e = (int) (Math.random() * words2.length);
            if (sb.length() + words2[e].length() <= nLen) {
                sb.append(words2[e]);
                //System.out.println(sb.length());
            }
        }
        System.out.println("StringBuilder time: " + (System.currentTimeMillis() - timeSB));
    }

    //выравнием текст пробелами
    public static void showText() {
        String[] rows = lukomor.split("\\n");
        int max = 0;
        for (int i = 0; i < rows.length; i++) {
            if (max < rows[i].length()) max = rows[i].length();
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() < max) {
                mark:
                while (true) {
                    for (int k = 0; k < rows[i].length(); k++) {
                        if (rows[i].charAt(k) == ' ' && rows[i].charAt(k + 1) != ' ') {
                            rows[i] = rows[i].substring(0, k) + " " + rows[i].substring(k);
                            k++;
                        }
                        if (rows[i].length() == max) break mark;
                    }
                }
                System.out.println(rows[i]);
            }
        }

    }

}
