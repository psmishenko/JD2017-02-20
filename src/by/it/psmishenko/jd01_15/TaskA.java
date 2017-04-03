package by.it.psmishenko.jd01_15;

import java.io.*;

/**
 * Created by user on 27.03.2017.
 */
public class TaskA {
    void runA(){
        int n = 4;
        int [][] arr = new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j] =(int)  ( Math.random()*30)-15;
                System.out.printf("%3d ",arr[i][j]);
            }
            System.out.println();
        }
        String root=System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_15/";
        String filename = path+"matrix.txt";
        try(FileWriter fs = new FileWriter(filename);
            PrintWriter pr = new PrintWriter(fs)){
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                   pr.printf("%3d ",arr[i][j]);
                }
                pr.print("\n");
            }
            pr.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
