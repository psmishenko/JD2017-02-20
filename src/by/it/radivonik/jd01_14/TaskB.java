package by.it.radivonik.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Radivonik on 24.03.2017.
 */
public class TaskB {
    public static void run() {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd01_14";
        String filename = path + "/taskB.txt";

        try (BufferedReader fr = new BufferedReader(new FileReader(filename))) {
            StringBuilder text = new StringBuilder();
            while (fr.ready())
                text.append(fr.readLine()+"\n");
            System.out.println(text);
            System.out.printf("Количество знаков препинания: %d\n",calCount(text.toString(),"[.,!?;-]"));
            System.out.printf("Количество слов: %d\n",calCount(text.toString(),"[а-яА-ЯёЁ]"));
        }
        catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static int calCount(String text, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text.toString());
        int count = 0;
        while (m.find())
            count++;
        return count;
    }
}
