package by.it.smirnov.jd01_15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.*;

/**
 * Матрица 4 на 4 из целых случайных чисел от -15 до 15.
 * Вывести матрицу на консоль и в текстовый файл matrix.txt, расположенный в папке задания
 * JD01_15. При выводе для каждого числа предусмотреть три знакоместа,
 * а между числами – один пробел.
 */
public class TaskA {
    public static void main(String[] args) {
        int count = 4;
        int[][] arr = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arr[i][j] = (int)floor(random()*31f-15f);
            }
        }
        ArrayList<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                sb.append(String.format("%3d ", arr[i][j]));
            }
            al.add(sb.toString());
            sb.setLength(0);
        }

        try (BufferedWriter br = new BufferedWriter( new FileWriter(System.getProperty("user.dir")+"/src/by/it/smirnov/jd01_15/matrix.txt"))) {
            String text;
            for (int i = 0; i < count; i++) {
                text = al.get(i) + "\n";
                br.write(text);
                System.out.print(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
