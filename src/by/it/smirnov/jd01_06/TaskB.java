package by.it.smirnov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 04.03.2017.
 */
public class TaskB {
    /**
     * В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой
     */
    public static void runPartA() {
        //String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        String[] words = Data.lukomor.split("[\\s\\n\\p{Punct}]+");
        //System.out.print(Arrays.toString(words));
        //System.out.println();
        int countWords = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Pattern pattern = Pattern.compile("[ауоыиэяюёеАУЫИЭЯЮЁЕ]");
            Matcher matcher = pattern.matcher(word);
            while (matcher.find()) {
                if (matcher.start() == 0) {
                    int lengthWord = word.length();
                    String lastChar = word.substring(lengthWord - 1);
                    Matcher matcherWord = pattern.matcher(lastChar);
                    while (matcherWord.find()) {
                        countWords++;
                        //System.out.println(word);
                    }
                }
                break;
            }
        }
        System.out.println("Количество слов, начинающихся и заканчивающихся гласной буквой: " + countWords);
    }

    /**
     * Вывести все предложения заданного текста в порядке возрастания количества
     * слов (!) в каждом из них. В предложениях нужно убрать переносы строк.
     */
    public static void runPartB() {
        String text = Data.lukomor.replaceAll("\n", " ");
        String[] proposals = text.split("[.!;?]+ ");
        int[][] arr = new int[proposals.length][2];
        for (int i = 0; i < proposals.length; i++) {
            String proposal = proposals[i].trim().replaceAll(" - "," ");
            String[] wordsProposal = proposal.split(" +");
            arr[i][0] = wordsProposal.length;
            arr[i][1] = i;
        }
        sortBubble(arr);
        System.out.println("Сортировка по количеству слов в строке:");
        for (int i = 0; i < arr.length; i++) {
            //System.out.println("Слов: " + arr[i][0]+" Предложение: "+proposals[arr[i][1]]);
            System.out.println("("+arr[i][0]+"):"+proposals[arr[i][1]]);
        }

    }

    /**
     * Функция сортировки двумерного массива по arr[0] int методом "пузырька"
     * @param arr массив
     */

    private static void sortBubble(int[][] arr) {
        boolean swap;
        int last = arr.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i][0]>arr[i+1][0]) {
                    int val0=arr[i][0];
                    int val1=arr[i][1];
                    arr[i][0] = arr[i+1][0];
                    arr[i][1] = arr[i+1][1];
                    arr[i+1][0] = val0;
                    arr[i+1][1] = val1;
                    swap = true;
                }
            }
            last --;
        } while (swap);
    }

}
