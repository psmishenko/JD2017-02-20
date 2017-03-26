package by.it.korzun.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static int calcCount(String pattern, String text){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        int count = 0;
        while (m.find()){
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/korzun/jd01_14/";
        String fileName = path + "TaskB.txt";

        FileReader fr = null;
        BufferedReader br = null;

        StringBuilder text = new StringBuilder();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (br.ready()){
                text.append(br.readLine()).append("\n");
            }
            System.out.println(text);

            int count1 = calcCount("[,.;?!-]", text.toString());
            int count2 = calcCount("[а-яА-ЯёЁ]+", text.toString());
            System.out.println(count1 + " " + count2);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
