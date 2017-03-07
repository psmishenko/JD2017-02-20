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

    // Формирование строки из миллиона символов
    public static void zad6() {
        String[] aWord = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        System.out.printf("\nString:");
        System.out.printf(
                "\nВремя формирования: %d миллисекунд",
                strMillionString(aWord));
        System.out.printf("\nStringBuilder:");
        System.out.printf(
                "\nВремя формирования: %d миллисекунд",
                strMillionStringBuilder(aWord));
    }

    static int MaxCountChar = 1000000;

    // Использование String
    public static long strMillionString(String[] aWord) {
        long start = System.currentTimeMillis();
        String s = "";
        int len = 0;

        do {
            String w = nextWord(aWord,MaxCountChar-len);
            s += w;
            len += w.length();
        }
        while (len < MaxCountChar);

        System.out.printf("\nДлина строки: %d",len);
        System.out.printf("\nПервые 50 символов: %s",s.substring(0,49));
        return System.currentTimeMillis() - start;
    }

    // Использование StringBuilder
    public static long strMillionStringBuilder(String[] aWord) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(MaxCountChar);
        int len = 0;

        do {
            String w = nextWord(aWord,MaxCountChar-len);
            sb.append(w);
            len += w.length();
        }
        while (len < MaxCountChar);

        System.out.printf("\nДлина строки: %d",len);
        System.out.printf("\nПервые 50 символов: %s",sb.substring(0,49));
        return System.currentTimeMillis() - start;
    }

    // Cлучайный выбор слова
    public static String nextWord(String[] aWord, int lenMax) {
        String res = "";
        int index = (int) (Math.random() * aWord.length);

        if (aWord[index].length() == lenMax)
            res = aWord[index];
        else if (aWord[index].length() < lenMax + 1)
            res = aWord[index] + " ";
        else { // поиск подходящего по длине слова
            int i = 0;
            while (i <= index) {
                for (int j = 0; j < aWord.length; j++) {
                    if (aWord[j].length() == lenMax) {
                        if (i == index)
                            res = aWord[j];
                        i++;
                    }
                }
            };
        }

        if (res.length() == 0) {
            for (int i = 0; i < lenMax; i++) {
                res += " ";
            }
        }

        return res;
    }
}
