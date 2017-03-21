package by.it.radivonik.jd01_06;

import java.util.regex.*;

/**
 * Created by Radivonik on 03.03.2017.
 */
public class TaskB {
    // Поиск слов, начинающихся и заканчивающихся гласной буквой
    public static void zad3() {
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        int c = 0;
        System.out.print("\nСлова, начинающиеся и заканчивающиеся гласной буквой:");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (isGlasnBegEnd(w)) {
                System.out.printf("\n%s",w);
                c++;
            }
        }
        System.out.println("\nКоличество слов, начинающихся и заканчивающихся гласной буквой: " + c);
    }

    // Проверка наличия гласных в начале и в коннце слова
    private static boolean isGlasnBegEnd(String s) {
        String glasn = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        boolean res = glasn.indexOf(s.charAt(0)) >= 0 && glasn.indexOf(s.charAt(s.length()-1)) >= 0;
        return res;
    }

    // Вывод предложений в порядке увеличения количества слов
    public static void zad4() {
        Pattern pPredl = Pattern.compile("[\\.!?;]+");
        String[] aPredl = pPredl.split(Data.lukomor); // массив предложений

        Matcher mPredl = pPredl.matcher(Data.lukomor);
        int mi = 0;
        while (mPredl.find()) { // цикл чтобы не потерять точки (или др. символы) в конце предложения
            aPredl[mi] = aPredl[mi] + mPredl.group().trim();
            mi++;
        }

        int[][] aPredlIndexLen = new int[aPredl.length][2]; // массив 'Индекс предложения - количество слов', будет отсортирован
        // определение количества слов в предложениях
        for (int i = 0; i < aPredl.length; i++) {
            aPredl[i] = aPredl[i].replace('\n', ' ').trim();
            String[] aWordPredl = aPredl[i].split("[^а-яА-ЯёЁ]+");
            aPredlIndexLen[i][0] = i;
            aPredlIndexLen[i][1] = aWordPredl.length;
        }

        // сортировка
        sortPredl(aPredlIndexLen);

        // Вывод предложений в отсортированном порядке
        System.out.print("\nПредложения, отсортированные по количеству слов (в скобках количество слов в предложении):");
        for (int i = 0; i < aPredl.length; i++) {
            System.out.printf("\n(%d) %s", aPredlIndexLen[i][1], aPredl[aPredlIndexLen[i][0]]);
        }
        System.out.println();
    }

    // Сортировка массива 'Индекс - количество слов'
    public static void sortPredl(int[][] aPredlIndexLen) {
        boolean swap;
        int last = aPredlIndexLen.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                // сортировка по второму элементу - количеству слов
                if (aPredlIndexLen[i][1] > aPredlIndexLen[i+1][1]) {
                    int[] aBuf = aPredlIndexLen[i];
                    aPredlIndexLen[i] = aPredlIndexLen[i+1];
                    aPredlIndexLen[i+1] = aBuf;
                    swap = true;
                }
            }
            last--;
        } while(swap);
    }
}
