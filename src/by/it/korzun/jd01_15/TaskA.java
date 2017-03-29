package by.it.korzun.jd01_15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {
    void run(){
        String path = System.getProperty("user.dir") + "/src/by/it/korzun/jd01_15/Matrix.txt";

        int [][]matrix = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = (int)(Math.random()*31 - 15);
            }
        }

        String []lines = new String[4];

        for (int i = 0; i < 4; i++) {
            lines[i] = String.format("%3d %3d %3d %3d", matrix[i][0], matrix[i][1], matrix[i][2], matrix[i][3]);
        }


        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(int i = 0; i < 4; i++){
                bw.write(lines[i]);
                bw.newLine();
            }
        }catch (IOException e){

        }


    }
}
