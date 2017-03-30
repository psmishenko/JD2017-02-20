package by.it.sorokoee.jd01_15;

import java.io.*;

public class MainA {


    public static void putmatrix(PrintWriter outStream) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                matrix[i][j] = matrix[i][j] = -15 + (int) (Math.random() * 30 + 1);
                System.out.printf("%+4d\t", matrix[i][j]);
                outStream.printf("%+4d\t", matrix[i][j]);
            }
            System.out.println();
            outStream.println();
        }
    };

    public static void main(String[] args) {


        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/sorokoee/jd01_15/";
        String fileName = path + "matrix.txt";

        try (FileWriter fr = new FileWriter(fileName);

             PrintWriter printWriter = new PrintWriter(fr)) {

            putmatrix(printWriter);
        } catch (IOException e) {

        }


    }
}
