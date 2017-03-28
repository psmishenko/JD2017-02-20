package by.it.prigozhanov.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    // comments 1
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/prigozhanov/jd01_15/";
        String filenameIn = "taskB.java";
        String filenameOut = "taskB.txt";

        try (FileReader fr = new FileReader(path + filenameIn)) {
            while (fr.ready()) {
                sb.append((char) fr.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //comments 2
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pt1 = Pattern.compile("/{2}([^\n]*)");  // сomments 3
        Matcher m1 = pt1.matcher(sb);
        while (m1.find()) {
            sb.delete(m1.start(), m1.end());
            m1.reset();
        }
        Pattern pt = Pattern.compile("(/\\*)([^*/]*)(\\*/)");
        Matcher m = pt.matcher(sb);
        while (m.find()) {
            sb.delete(m.start(), m.end());
            m.reset();
        }
//        Pattern pt2 = Pattern.compile("(/\\*{2})(^(\\*/)*");
//        Matcher m2 = pt2.matcher(sb);
//        while (m2.find()) {
//            System.out.println(m2.group());
//        }
        String s = new String(sb);
        String[] sArr = s.split("\\n");
        for (int i = 0; i < sArr.length; i++) {
            if (i+1<10) {
                System.out.printf("0%d %s\n", i+1, sArr[i]);
            } else
            System.out.printf("%2d %s\n", i+1, sArr[i]);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(path+filenameOut))) {
            String[] sArr1 = s.split("\\n");
            for (int i = 0; i < sArr.length; i++) {
                if (i+1<10) {
                    pw.printf("0%d %s\n", i+1, sArr[i]);
                } else
                    pw.printf("%2d %s\n", i+1, sArr[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* comments 4
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
/*  wd ad aw
a wdawawda
wda
 */
