package by.it.psmishenko.jd01_2;


import java.util.Random;

public class TaskC {
    static int[][] createMatrix (int num){
        int newArray[][] = new int[num][num];
        Random rand = new Random();
        for (int i = 0; i <num ; i++) {
            for (int j = 0; j <num ; j++) {
                newArray[i][j] = rand.nextInt(num) - rand.nextInt(num);
                System.out.printf("a[%-2d,%2d]= %-4d ",i,j,newArray[i][j]); // подправлено после jd01_3
            }
            System.out.println(" ");
        }
        return newArray;
    }
}
