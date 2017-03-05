package by.it.smirnov.jd01_06;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 04.03.2017.
 */
public class TaskC {
    /**
     * Выполнить форматирование текста с выравниванием по обоим краям. Для этого
     * добавить дополнительные пробелы между словами.
     */
    public static void runPartA() {
        String[] lines = Data.lukomor.split("\n+");
        int maxLengthLine = getMaxLengthElementArray(lines);
        //System.out.println(maxLengthLine);
        for (int i = 0; i < lines.length; i++) {
            //System.out.println(lines[i]);
            String line = lines[i].trim();
            int lengthLine = line.length();
            if (lengthLine < maxLengthLine) {
                String[] words = line.split(" ");
                int countSpaceInLine = words.length - 1;
                if (countSpaceInLine > 0){
                    int countSpace = (maxLengthLine - lengthLine)/countSpaceInLine;              // Сколько пробелов добавить в каждую позицию
                    int countPositionSpacePlus1 = (maxLengthLine - lengthLine)%countSpaceInLine; // Сколько позиций с кол-вом пробелов countSpace + 1
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < words.length; j++) {
                        sb.append(words[j]);
                        if (j != words.length - 1) {
                            for (int k = 0; k <= countSpace; k++) sb.append(" ");
                            if (countPositionSpacePlus1 > 0) {
                                sb.append(" ");
                                countPositionSpacePlus1--;
                            }
                        }
                    }
                    lines[i] = sb.toString();
                }
            }
            System.out.println(lines[i]);
        }
    }

    private static int getMaxLengthElementArray(String[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].trim().length() > result) result = arr[i].length();
        return result;
    }

    /**
     * Считаем, что в массиве найдется слово соответствующей длины.
     * В противном случае нужно делать подбор. Много писать.
     */
    private static String selectionElemetOnLength(String[] arr, int length) {
        String result = "";
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length() == length) {
                result = arr[i];
                break;
            }
        return result;
    }

    /**
     * Сложить из случайных слов стихотворения строку String ровно (!) в один миллион
     * символов путем конкатенации. Слова через пробел. Последнее слово нужно
     * подобрать по длине.
     */
    static int MAX_Elements = 1000000;
    public static void runPartB() {
        String[] words = Data.lukomor.split("[\\s\\n\\p{Punct}]+");

        int maxLengthWord = getMaxLengthElementArray(words);
        Random r = new Random();

        // Конкатенация
        long startTime = System.currentTimeMillis();
        String string = "";
        while (MAX_Elements - string.length() > maxLengthWord)
            string += words[(int) (r.nextDouble() * words.length)] + " ";
        string += selectionElemetOnLength(words, MAX_Elements - string.length());
        System.out.printf("Время выполнения через конкатенацию: %7.3f мкс%n", (double)(System.currentTimeMillis() - startTime) / 1000);

        //System.out.println(string);
        //System.out.println(string.length());

        // StringBuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        while (MAX_Elements - sb.length() > maxLengthWord)
            sb.append(words[(int)(r.nextDouble()*words.length)] + " ");
        sb.append(selectionElemetOnLength(words, MAX_Elements - sb.length()));
        System.out.printf("Время выполнения через StringBuilder: %7.3f мкс%n",(double)(System.currentTimeMillis()-startTime)/1000);

        //System.out.println(sb.toString());
        //System.out.println(sb.length());

        // StringBuilder и setLength
        startTime = System.currentTimeMillis();
        StringBuilder sbL = new StringBuilder();
        sbL.setLength(MAX_Elements);
        while (MAX_Elements - sbL.length() > maxLengthWord)
            sbL.append(words[(int) (r.nextDouble() * words.length)] + " ");
        sbL.append(selectionElemetOnLength(words, MAX_Elements - sbL.length()));
        System.out.printf("Время выполнения через StringBuilder с setLength: %7.3f мкс%n", (double)(System.currentTimeMillis() - startTime) / 1000);


    }


}
