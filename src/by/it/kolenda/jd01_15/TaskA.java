package by.it.kolenda.jd01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/kolenda/jd01_15/";
        String filename = path + "matrix.txt";

        try (PrintWriter pr = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = ((int) (Math.random() * 31) - 15);
                    System.out.printf("%3d ", matrix[i][j]);
                    pr.printf("%3d", matrix[i][j]);
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