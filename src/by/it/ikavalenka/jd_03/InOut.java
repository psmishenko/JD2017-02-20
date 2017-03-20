package by.it.ikavalenka.jd_03;

import java.util.Scanner;

/**
 * Created by USER on 24.02.2017.
 */
public class InOut {
        static String consoleReadline(){
            Scanner  scanner=new Scanner(System.in);
            String res=scanner.nextLine();
            return res;

        }
        static double[] readDoubleArrayFromLine(String line){
            line=line.trim();
            String[] strValue=line.split(" ");
            double[] res=new double[strValue.length];
            for (int i =0; i < strValue.length; i++){
                res[i]=Double.parseDouble(strValue[i]);
            }
                return res;
        }
         static void printDoubleArray(double[] arr, String name, int countCols){
             System.out.println("Array" +name);
            for (int i = 0;i < arr.length; i++) {
                System.out.printf("%s[% -3d]=%-10.5f", name, i, arr[i]);
                if ((i + 1) % countCols == 0)
                    System.out.println();
            }
         }
         public static void printArrayS (double [] [] k){
             for (int i = 0; i <k.length ; i++) {
                 for (int j = 0; j <k[0].length ; j++) {
                     System.out.printf("%s[% -3d]=%-10.5f",k[i][j]);

                 }

                 System.out.println();
             }
             System.out.println();
         }
        public static void printArrayS (double [] [] k, String name){
            System.out.println("Second " + name);
            for (int i = 0; i < k.length ; i++) {
                for (int j = 0; j <k[0].length ; j++) {
                    System.out.printf("%s[% -3d]=%-10.5f",i,j,k[i][j]);

                }
                System.out.println();
            }
            System.out.println();
        }

}
