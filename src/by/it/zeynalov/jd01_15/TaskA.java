package by.it.zeynalov.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        Random rand = new Random();

        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/zeynalov/jd01_15/";
        String filename = path + "matrix.txt";

        try (FileWriter fos = new FileWriter(filename);
             PrintWriter pw = new PrintWriter(fos)) {

            int[][] mass = new int[4][4];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    mass[i][j] = -15 + rand.nextInt(31);
                    pw.printf("%3d ", mass[i][j]);
                    System.out.printf("%3d ", mass[i][j]);
                }
                System.out.println();
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
