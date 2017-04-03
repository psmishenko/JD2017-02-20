package by.it.vedom.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    /**
     * @param pattern регулялное выражение
     * @param txt где будем искать
     * @return найденное количество
     */
    private static int calccalc(String pattern, String txt) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt.toString());
        int count = 0;
        while(m.find()) count++;
        return count;
    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/vedom/jd01_14/";
        String fileName = path + "TaskB.txt";

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        StringBuilder text = new StringBuilder();
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()) {

                text.append(bufferedReader.readLine()).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //---------------------------------
        finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //--------------------------------
        System.out.println(text);
        int count1 = calccalc("[.,;?!-:]", text.toString());
        //int count1 = calccalc("[.,;?!-:]", "У лукоморья дуб зелёный; И т.д");
        int count2 = calccalc("[а-яА-ЯёЁ]+", text.toString());
        //int count2 = calccalc("[а-яА-ЯёЁ]+", "У лукоморья дуб зелёный; И т.д");
        System.out.println(count1+ "+" +count2);

    }
}
