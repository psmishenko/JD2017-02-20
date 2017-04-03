package by.it.radivonik.jd01_15;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Created by Radivonik on 27.03.2017.
 * Класс, реализующий задания Варианта B
 */
public class TaskB {
    public void run() {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd01_15";
        String filename = path + "/TaskB.java";

        // Чтение из файла в строку
        StringBuilder strSrc = new StringBuilder();
        try (BufferedReader fr = new BufferedReader(new FileReader(filename))) {
           String line;
           while ((line = fr.readLine()) != null)
               strSrc.append(line + "\n");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Разбор искодной строки и формирование новой строки
        StringBuilder strOut = new StringBuilder();
        Pattern p = Pattern.compile("\\\"|\\/\\/|\\n|\\/\\*|\\*\\/");
        Matcher m = p.matcher(strSrc.toString());
        Comments com = new Comments();
        while (m.find()) {
            // символ '"' (и перед ним нет символа '\')
            if (m.group().equals("\"") && !(m.start() > 0 && (strSrc.charAt(m.start() - 1) == '\\')) &&
                !com.isCommentOneLine && !com.isCommentMultiLine)
                com.isQuotes = !com.isQuotes; // изменение признака "кавычки"
            // символы '//'
            else if (m.group().equals("//") && !com.isQuotes && !com.isCommentOneLine && !com.isCommentMultiLine) {
                strOut.append(strSrc.substring(com.posCopyBegin, m.start()));
                com.isCommentOneLine = true; // начало комментария
                com.posCopyBegin = m.start(); // запоминание текущей позиции
            }
            // символ '\n'
            else if (m.group().equals("\n") && com.isCommentOneLine) {
                com.isCommentOneLine = false; // окончание комментария
                com.posCopyBegin = m.start(); // запоминание текущей позиции
            }
            // символы '/*'
            else if (m.group().equals("/*") && !com.isQuotes && !com.isCommentOneLine && !com.isCommentMultiLine) {
                strOut.append(strSrc.substring(com.posCopyBegin, m.start()));
                com.isCommentMultiLine = true; // начало комментария
                com.posCopyBegin = m.start(); // запоминание текущей позиции
            }
            // символы '*/'
            else if (m.group().equals("*/") && com.isCommentMultiLine) {
                com.isCommentMultiLine = false; // окончание комментария
                com.posCopyBegin = m.start() + 2; // запоминание текущей позиции
            }
        }
        strOut.append(strSrc.substring(com.posCopyBegin, strSrc.length()));

        // Подготовка форматированного списка
        List<String> listOut = new ArrayList<String>() {
            @Override
            public String toString() {
                int n = 1;
                StringBuilder res = new StringBuilder();
                for (String s: this) {
                    res.append(String.format("%3d %s\n",n,s));
                    n++;
                }
                return res.toString();
            }
        };
        listOut.addAll(Arrays.asList(strOut.toString().split("\\n")));

        // Вывод в консоль
        System.out.print(listOut);

        // Вывод в файл
        try (PrintWriter prn = new PrintWriter(new FileWriter(filename.replace(".java",".txt")))) {
            prn.print(listOut);
        }
        catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // внутренний класс для сохранения текущего состояния выделения комментариев в строке
    private class Comments {
        boolean isQuotes = false;
        boolean isCommentOneLine = false;
        boolean isCommentMultiLine = false;
        int posCopyBegin = 0;
    }
}
