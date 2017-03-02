package by.it.radivonik.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 24.02.2017.
 */
public class InOut {
    static String consoleReadLine() {
//        Scanner scanner = new Scanner(System.in);
//        String res = scanner.nextLine();
//        return res;

        return new Scanner(System.in).nextLine();
    }

    static double[] readDoubleArrayFromLine(String line) {
        line = line.trim();
        String[] strValues = line.split(" ");

        double[] res = new double[strValues.length];

        for (int i = 0; i < strValues.length; i++) {
            res[i] = Double.parseDouble(strValues[i]);
        }

        return res;
    }

    static void printDoubleArray(double[] ar, String name, int colCount) {
        System.out.println("Array " + name);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s[%d]=%-10.5f ",name,i,ar[i]);
            if ((i+1)%colCount == 0)
                System.out.println();
        }
    }
}
