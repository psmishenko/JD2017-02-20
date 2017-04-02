package by.it.ikavalenka.jd_15.jd_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by USER on 27.03.2017.
 */
public class TaskA {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir") + "/src/JD_01_2017_03/";
        String fileOut = root + "/jd_15/matrix.txt";
        int[][] m2 = new int[4][4];
        {
            int max = 30;
            int min = 15;
            for (int i = 0; i < m2.length; i++) {

                for (int j = 0; j < m2[i].length; j++) {

                    m2[i][j] = ((int) (Math.random() * max) - min);  // need clarification
                }
            }
//            for (int i = 0; i < m2.length; i++) {
//
//                for (int j = 0; j < m2[i].length; j++) {
//
//                    System.out.printf("%3d ",m2[i][j]);
//                }
//                System.out.println();
//
//      }
        print(m2,"console");

        }

//
//        try (PrintWriter printer = new PrintWriter(
//                new FileWriter(fileOut, false))) {
//
//            for (int i = 0; i < m2.length; i++) {
//                int row;
//                for (int j = 0; j < m2[i].length; j++) {
//                    row = m2[i][j];
//                    String forFile = String.format("%3d ", row);
//                    System.out.print(forFile);
//                    printer.print(forFile);
//                }
//                System.out.println();
//                printer.println();
//            }
//        } catch (IOException e) {
//            throw new IOException("Writting is failed" + fileOut, e);
//        }
        print(m2,fileOut);
    }

    static void print(int[][] array, String target) {
        if (target.equals("console")) {

            for (int i = 0; i < array.length; i++) {

                for (int j = 0; j < array[i].length; j++) {

                    System.out.printf("%3d ", array[i][j]);
                }
                System.out.println();
            }

        }else {

            try (PrintWriter printer = new PrintWriter(
                    new FileWriter(target, false))) {

                for (int i = 0; i < array.length; i++) {
                    int row;
                    for (int j = 0; j < array[i].length; j++) {
                        row = array[i][j];
                        String forFile = String.format("%3d ", row);
                        System.out.print(forFile);
                        printer.print(forFile);
                    }
                    System.out.println();
                    printer.println();
                }
            } catch (IOException e) {
                System.out.println("Writting is failed" + array);
            }

        }


    }
}

