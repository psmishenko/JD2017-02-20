package by.it.smirnov.jd01_03;

import java.util.Scanner;

/**
 * Created by aleksey.smirnov on 24.02.2017.
 */
public class InOut {
    /**
     * Функция чтения строки с консоли
     * @version 1.0.0
     * @return строка
     */
    public static String consoleReadLine() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Функция преобразования строки в массив double
     * @version 1.0.0
     * @param line строкм
     * @param separator разделитель
     * @return массив double[]
     */
    public static double[] readDoubleArrayFromLine(String line, String separator) {
        line = line.trim();
        String[] strValues = line.split(separator);
        double[] res = new double[strValues.length];
        for (int i = 0; i < res.length; i++)
            res[i] = Double.parseDouble(strValues[i]);
        return res;
    }

    /**
     * Функция печати значений одномерного массива double
     * @version 1.0.0
     * @param arr массив
     */
    public static void printDoubleArray(double[] arr) {
        for (double elem : arr)
            System.out.printf("%-10.5f",elem);
        System.out.println();
    }

    /**
     * Функция форматированной печати значений одномерного массива double
     * @version 1.0.0
     * @param arr массив
     * @param name наименование массива
     * @param countCols количество столбцов в строке вывода
     */
    public static void printDoubleArray(double[] arr, String name, int countCols) {
        System.out.println("Array " + name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%10.5f ",name, i, arr[i]);
            if ((i+1)%countCols==0)
                System.out.println();
        }
        System.out.println();
    }

    /**
     * Функция печати значений двумерного массива double
     * @version 1.0.0
     * @param m массив
     */
    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.printf("%6.2f",m[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Функция форматированной печати значений двумерного массива double
     * @version 1.0.0
     * @param m массив
     * @param name наименование массива
     */
    public static void arrayPrint2D(double[][] m, String name) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.printf(name+"[%1d,%1d]=%-7.1f",i,j,m[i][j]);
            System.out.println();
        }
        System.out.println();
    }
}
