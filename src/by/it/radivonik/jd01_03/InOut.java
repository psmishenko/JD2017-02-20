package by.it.radivonik.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 24.02.2017.
 */
public class InOut {
    /**
     * @version 1.0
     * @return вводимая строка с консоли
     */
    static String consoleReadLine() {
//        Scanner scanner = new Scanner(System.in);
//        String res = scanner.nextLine();
//        return res;

        return new Scanner(System.in).nextLine();
    }

    /**
     * @version 1.0
     * @param line строка из чисел
     * @return массив double
     */
    static double[] readDoubleArrayFromLine(String line) {
        line = line.trim();
        String[] strValues = line.split(" ");

        double[] res = new double[strValues.length];

        for (int i = 0; i < strValues.length; i++) {
            res[i] = Double.parseDouble(strValues[i]);
        }

        return res;
    }

    /**
     * @version 1.0
     * @param ar массив double для печати
     * @param name название массива
     * @param colCount количество выаодимых колонок
     */
    public static void printDoubleArray(double[] ar, String name, int colCount) {
        System.out.println("Массив " + name);
        for (int i = 0; i < ar.length; i++) {
            System.out.printf("%s[%d]=%-10.5f ",name,i,ar[i]);
            if ((i+1)%colCount == 0)
                System.out.println();
        }
    }

    /**
     * @version 1.0
     * @param ar двумерный массив double для печати
     * @param name название массива
     * @param colCount количество выаодимых колонок
     */
    public static void printDoubleArray(double[][] ar, String name, int colCount) {
        System.out.println("Массив " + name);
        for (int i = 0; i < ar.length; i++) {
            printDoubleArray(ar[i],name+String.format("[%d]",i),colCount);
        }
    }
}
