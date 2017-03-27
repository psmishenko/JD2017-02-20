package by.it.prigozhanov.jd01_15;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    // comments 1
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/prigozhanov/jd01_15/";
        String filename = "taskB.java";
        try (FileReader fr = new FileReader(path + filename)) {
            while (fr.ready()) {
                sb.append((char) fr.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //comments 2
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pt = Pattern.compile("(/\\*)(([а-яА-ЯёЁa-zA-Z0-9.\\-;:,\n])*[\\s]*)*(\\*/)");
        Pattern pt1 = Pattern.compile("(//)(([а-яА-ЯёЁa-zA-Z0-9.\\-;:,])*[\\s]*)*(\\n)");  // долго ищет, не знаю почему
        Matcher m = pt.matcher(sb);
        Matcher m1 = pt1.matcher(sb);
        while (m.find()) {
            System.out.println("start "+ m.start());
            System.out.println("end" + m.end());
            System.out.println("len" + sb.length());
        }
        String s = new String(sb);
        /* comments 3
        3223.-;
        kighk
        323
         */
        /*dawda
        dawdaw
        adwad
         */

    }
}
