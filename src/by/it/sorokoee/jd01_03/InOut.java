package by.it.sorokoee.jd01_03;

import java.util.Scanner;

public class InOut {
    public static String consoleReadLine() {
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        return res;
//        return  new Scanner(System.in).nextLine(); краткая запись
    }

    public static double[] readDoubleArrayFromLine(String line) {
        line = line.trim();
        String[] strValues = line.split(" ");
        double[] res = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            res[i] = Double.parseDouble(strValues[i]);

        }
        return res;

    }


    public static void printDoubleArray(double[] arr, String name, int size) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f",name, i, arr[i]);
            if (((i + 1) % size == 0) || (arr.length - 1 == i)) {
                System.out.println();
            }

        }
        System.out.println();
    }
    public  static void printArray2D(double[][] mass, String name) {
        for (int i = 0; i <mass.length ; i++) {
            for (int j = 0; j <mass[i].length ; j++) {
                System.out.printf("%s[%1d,%1d]=%-10.3f",name, i,j, mass[i][j]);

            }

            System.out.println();
        }
        System.out.println();
    }






}
