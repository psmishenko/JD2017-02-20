package by.it.tereshko.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        int[][] matr = new int[4][4];
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/tereshko/jd01_15/";
        String filename = path + "matrix.txt";

        try (PrintWriter pr = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < matr.length; i++) {
                for (int j = 0; j < matr[i].length; j++) {
                    matr[i][j] = ((int) (Math.random() * 31) - 15);
                    System.out.printf("%3d ", matr[i][j]);
                    pr.printf("%3d", matr[i][j]);
                }
                System.out.println();
                pr.println();
            }
            pr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
