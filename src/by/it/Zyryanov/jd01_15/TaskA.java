package by.it.Zyryanov.jd01_15;


import java.io.*;

public class TaskA {
    public static void main(String[] args) {

        int[][] m = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = (int) (Math.random() * 16) - 15;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%3d", m[i][j]);
            }
            System.out.println();
        }

        String path = "/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd01_15/";
        String filename = path + "matrix.txt";

        try (FileWriter fw = new FileWriter(filename);
             PrintWriter writer = new PrintWriter(fw)) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    writer.printf("%3d", m[i][j]);
                }
                writer.print("\n");
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
