package by.it.radivonik.jd01_06;

/**
 * Created by Radivonik on 03.03.2017.
 */
public class TaskB {
    private static boolean isGlasnBegEnd(String s) {
        String glasn = "аеёиоуыэюяАЕЁИОУЫЭЮЯ";
        boolean res = glasn.indexOf(s.charAt(0)) >= 0 && glasn.indexOf(s.charAt(s.length()-1)) >= 0;
        return res;
    }

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
}
