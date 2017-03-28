package by.it.prigozhanov.jd01_15;

import java.io.*;

/**
 * Created by v-omf on 3/27/2017!
 */
public class TaskA {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/prigozhanov/jd01_15/";
        String fileName = "taskA.txt";
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (int) (Math.random() * 30) - 15;
            }

        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%d   ", matrix[i][j]);
            }
            System.out.println();
        }

        try (PrintWriter pr = new PrintWriter(new FileWriter(path+fileName, true))) {
            pr.println("new Matrix");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    pr.printf("%d   ", matrix[i][j]);
                }
                pr.println();
            }
            pr.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
