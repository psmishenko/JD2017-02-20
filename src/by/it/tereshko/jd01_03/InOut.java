package by.it.tereshko.jd01_03;

import java.util.Scanner;

public class InOut {
    static String consoleReadLine() {
//        int i = 89;
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        return res;
//        return new Scanner(System.in).nextLine();
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

    static void printDoubleArray(double[] arr, String name, int countCols) {
        System.out.println("Array " + name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f ", name, i, arr[i]);
            if ((i + 1) % countCols == 0)
                System.out.println();
        }
    }
}
