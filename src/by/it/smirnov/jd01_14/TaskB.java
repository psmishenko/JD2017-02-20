package by.it.smirnov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс задачи B
 */
public class TaskB {
    /**
     * Функция подсчета в файле с текстом количества знаков препинания и слов.
     * @version 1.0.0
     */
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/src/by/it/smirnov/jd01_14/";
        String fileName = path + "taskB.txt";
        System.out.println("Вывод из файла:");
        try (FileReader fr = new FileReader(fileName)){
            char[] arr = new char[10];
            int b;
            StringBuilder sb = new StringBuilder();
            while ((b= fr.read(arr)) != -1) {
               sb.append(arr, 0, b);
            }

            System.out.println(sb);
            System.out.println();
            int count = 0;
            Pattern pat=Pattern.compile("[,.?!;-]");
            Matcher matcher=pat.matcher(sb.toString());
            while (matcher.find()) count++;
            System.out.println("Количество знаков препинания: "+count);
            System.out.println("Количество слов: "+sb.toString().split("[\\s\\n\\p{Punct}]+").length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
