package by.it.ikavalenka.jd_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 24.03.2017.
 */
public class TaskB {
    private static int calcCount(String pattern, String text) {
        Pattern p = Pattern.compile("[,.?!;-]+");
        Matcher m = p.matcher(text.toString());
        int count = 0;
        while (m.find()) count++;
        return count;}

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/ikavalenka/jd_14/";
//        String filename = path + "TaskB.txt";
        String filename = path + "Jd14taskB.txt";
        FileReader fr;
        BufferedReader br = null;
        StringBuilder text = new StringBuilder();
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            while (br.ready()) {
                text.append(br.read()).append("\n");
            }
            System.out.println(text);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        int count1 = calcCount("[,.?!;-]", text.toString());
        int count2 = calcCount("[а-яА-ЯёЁ]+", text.toString());
        System.out.println(count1 + " " + count2);


    }
}


