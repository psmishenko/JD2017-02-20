package by.it.ikavalenka.jd_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by USER on 27.03.2017.
 */
public class TaskA {
    public static void main(String[] args) throws IOException  {
        String root = System.getProperty("user.dir") + "/src/JD_01_2017_03/";
        String fileOut = root + "/jd_15/matrix.txt";
        int[][] m2 = new int[4][4];
        {
            int max = 30;
            int min = 15;
            for (int i = 0; i < m2.length; i++) {

                for (int j = 0; j < m2[i].length; j++) {

                    m2[i][j] = ((int) (Math.random()*max) - min);  // need clarification
                }
            }
            for (int i = 0; i < m2.length; i++) {

                for (int j = 0; j < m2[i].length; j++) {

                    System.out.printf(m2[i][j] + "\t");
                }
                System.out.println();
            }
        }
        try (PrintWriter printer = new PrintWriter(
                new FileWriter(fileOut, false))) {

            for (int i = 0; i < m2.length; i++) {
                String row = " ";
                for (int j = 0; j < m2[i].length; j++) {
                    row += m2[i][j] + "\t";
                }
                printer.println(row);
                System.out.format(row);
                System.out.println();
            }
        } catch (IOException e) {
            throw new IOException("Writting is failed" + fileOut, e);
        }
    }
}
