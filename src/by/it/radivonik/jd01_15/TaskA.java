package by.it.radivonik.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by Radivonik on 27.03.2017.
 */
public class TaskA {
    public static void run() {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd01_15";
        String filename = path + "/matrix.txt";
        int[][] m = new int[4][4];

        // Заполнение матрицы
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.round(Math.random() * 30) - 15);
            }
        }

        // Форматирование матрицы с сохранением в ArrayList
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            StringBuilder s = new StringBuilder("");
            for (int j = 0; j < m[i].length; j++) {
                s.append(String.format(" %3d",m[i][j]));
            }
            s.append("\n");
            strList.add(s.toString());
        }

        // Вывод матрицы на консоль
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }

        // Вывод матрицы в файл
        try (PrintWriter prn = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < strList.size(); i++) {
                prn.println(strList.get(i));
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
