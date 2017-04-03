package by.it.smirnov.jd01_15;

import java.io.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 * Из прочитанного текста программы необходимо удалить все возможные виды комментариев.
 * Результат необходимо вывести с номерами строк в двухзначном формате на консоль и в файл
 * с тем же местоположением и именем, но с расширением txt.
 */
public class TaskB {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/src/by/it/smirnov/jd01_15/";
        String fileName = path + "TaskB.java";
        String fileNameOut = path + "TaskB.txt";
        System.out.println(fileName);
        StringBuilder sb = new StringBuilder();
        String line;
        try (LineNumberReader lr = new LineNumberReader(new FileReader(fileName))){
            while((line = lr.readLine())!=null) {
                int pos = line.indexOf("//");
                if (pos!=-1)
                    sb.append(line.substring(0,pos));
                else
                    sb.append(line);
                if (pos!=0) sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = sb.toString();
        String[] arr = text.split("/\\*[\\D\\d]*?\\*/"); // Комментарий для удаления
//        Pattern p = Pattern.compile("/\\*\\*[\\D\\d]*?\\*/");
/*
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        };
*/
        sb = new StringBuilder();
        for (String el : arr) {
            sb.append(el);
        }
        //System.out.println(sb.toString());
        String[] arrStr = sb.toString().split("\n");
        int count = 0;
        try (FileWriter fr = new FileWriter(new File(fileNameOut))){
            for (String elStr:arrStr) {
                count ++;
                String resStr = String.format("%2d : %s", count, elStr + "\n");
                fr.write(resStr);
                System.out.print(resStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
