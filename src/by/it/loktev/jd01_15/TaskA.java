package by.it.loktev.jd01_15;

import java.io.*;

public class TaskA {

    public static void taskA() {

        int[][] matrix = new int[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                matrix[row][col]=(int)Math.floor(Math.random()*31)-15;
            }
        }

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.printf("%3d ",matrix[row][col]);
            }
            System.out.println("");
        }

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_15/";
        String fileName=basePath+"matrix.txt";

        try (
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
        )
        {
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    bw.write(String.format( "%3d ",matrix[row][col]));
                }
                bw.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
