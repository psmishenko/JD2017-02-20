package by.it.radivonik.jd01_06;

import java.util.regex.*;

/**
 * Created by Radivonik on 03.03.2017.
 */
public class TaskC {
    // Выравнивание текста по ширине
    public static void zad5() {
        String[] aLine = Data.lukomor.split("[\n]");
        int lenMax = 0;

        // определение максимальной ширины строки
        for (String s: aLine) {
            if(lenMax < s.length())
                lenMax = s.length();
        }

        // форматирование строк
        for (int i = 0; i < aLine.length; i++) {
            StringBuilder sbLine = new StringBuilder(aLine[i]);
            int len = sbLine.length();

            while (len < lenMax) { // цикл, пока длина строки не достигнет максимальной
                Pattern pLine = Pattern.compile(" +");
                Matcher mLine = pLine.matcher(sbLine.toString());
                int countIns = 0; // счетчик добавленных пробелов = счетчик смещения
                while (mLine.find()) { // поиск пробелов
                    sbLine.insert(mLine.start()+countIns," "); // вставка пробелов
                    len++; // счетчик длины строки
                    countIns++; // счетчик добавленных пробелов
                    if (len >= lenMax) // выход из цикла поиска пробелов при необходимости
                        break;
                }
            }
            System.out.printf("\n%s",sbLine);
        }
        System.out.println();
    }

    public static void zad6() {
    }
}
