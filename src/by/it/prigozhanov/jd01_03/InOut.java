package by.it.prigozhanov.jd01_03;


import java.util.Scanner;

/**
 * Created by Vladimir on 24.02.2017.
 */
public class InOut {
   static String consoleReadLine() {
       Scanner scanner = new Scanner(System.in);
       String res= scanner.nextLine();
       return res;
   }

   static double[] readDoubleArrayFromString(String line) {
       line=line.trim();
       String[] strValues =line.split(" ");
       double[] res=new double[strValues.length];
       for (int i = 0; i <strValues.length ; i++) {
           res[i] = Double.parseDouble(strValues[i]);
                  }
                  return res;
   }

    static int[] readArrayFromString(String line) {
        line=line.trim();
        String[] strValues =line.split(" ");
        int[] res=new int[strValues.length];
        for (int i = 0; i <strValues.length ; i++) {
            res[i] = Integer.parseInt(strValues[i]);
        }
        return res;
    }

   static void printDoubleArray(double[] arr, String name, int countCols) {
       System.out.println("Array " + name)  ;
       for (int i = 0; i < arr.length; i++){
           System.out.printf("%s[% -3d]=%-10.5f",name,i, arr[i]);
           if ((i+1)%countCols==0) System.out.println();
       }

   }

   public static void printArray2D(double[][] m) {
       for (int i = 0; i < m.length; i++) {
           for (int j = 0; j < m[0].length; j++) {
               System.out.printf("% 8.2f", m[i][j]);
           }
           System.out.println();
       }
       System.out.println();
   }
    public static void printArray2D(double[][] m, String name) {
        System.out.println("Matrix " + name + ":");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf(name + "[%-1d,%-1d]=%-8.2f", i, j, m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


}
