package by.it.prigozhanov.jd01_02;

import java.io.IOException;

/**
 * Created by v-omf on 2/24/2017.
 */
public class TaskC {
    public static void main(String[] args) throws IOException {
//        String s = ValueSaver.GetLine();
//        int n = ValueSaver.strToInt(s);
        int rand = (int) (Math.random() * 20);
        int[][] doubleArr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        for (int i = 0; i < doubleArr.length; i++) {
            for (int j = 0; j < doubleArr[0].length; j++) {
                System.out.printf("%-4d", doubleArr[i][j]);
            }
            System.out.println();
        }

        System.out.println("TR matrix");
        int[][] transponmatrix = new int[doubleArr[0].length][doubleArr.length];
        for (int i = 0; i < doubleArr[0].length; i++) {
            for (int j = 0; j < doubleArr.length; j++) {
                transponmatrix[i][j] = doubleArr[j][i];
                System.out.print(transponmatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("90degmatrix");
        int[][] matrix90deg = new int[transponmatrix[0].length][transponmatrix.length];
        for (int i = 0; i < transponmatrix[0].length; i++) {
            for (int j = 0; j < transponmatrix.length; j++) {
                for (int k = transponmatrix.length; k > 0; k--) {
                    matrix90deg[i][j] = transponmatrix [j][k];
                }
                 System.out.print(transponmatrix[j][i] + " ");
            }
            System.out.println();
        }


    }
}
