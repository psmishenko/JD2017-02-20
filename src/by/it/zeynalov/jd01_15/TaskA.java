package by.it.zeynalov.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {
    public static void main(String[] args) {
        Random rand = new Random();

        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/zeynalov/jd01_15/";
        String filename = path + "matrix.txt";

        try (FileOutputStream fos = new FileOutputStream(filename)) {
          //  PrintWriter pw = new PrintWriter(new FileWriter(fos);
            int[][] mass = new int[4][4];
            for (int i = 0; i < mass.length; i++) {
                System.out.println();
                for (int j = 0; j < mass.length; j++) {
                    mass[i][j] = rand.nextInt(15);
                  //  pw.printf("%3d ", mass[i][j]);
                    fos.write(mass[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
