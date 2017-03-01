package by.it.smirnov.jd01_03;


import java.util.Arrays;

/**
 * Created by aleksey.smirnov on 24.02.2017.
 */
public class Util {
    /**
     * Функция сортировки одномерного массива double методом "пузырька"
     * @version 1.0.0
     * @param arr массив
     */
    public static void sortBubble(double[] arr) {
        boolean swap;
        int last = arr.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]) {
                    double buff=arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                    swap = true;
                }
            }
            last --;
        } while (swap);
    }

    /**
     * Функция сортировки одномерного массива double методом сортировки выбором
     * @version 1.0.0
     * @param arr массив
     */
    public static void sortSelectMin(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double minValue = Double.MAX_VALUE;
            int index = 0;
            for (int j = i; j < arr.length; j++)
                if (minValue>arr[j]) {
                    minValue = arr[j];
                    index = j;
                }
            if (i!=index) {
                double buff = arr[i];
                arr[i] = arr[index];
                arr[index] = buff;
            }
        }
    }

    /**
     * Функция сортировки одномерного массива double средствами Java (Arrays.sort)
     * @version 1.0.0
     * @param arr массив
     */
    public static void sortDefault(double[] arr) {
        Arrays.sort(arr);
    }

    /**
     * Функция поиска минимального значения одномерного массива double
     * @version 1.0.0
     * @param arr массив
     * @return минимальное значений
     */
    public static double minDoubleArray(double[] arr) {
        double result = Double.MAX_VALUE;
        for (double i : arr)
            if (i<result) result=i;
        return result;
    }
    /**
     * Функция поиска максимального значения одномерного массива double
     * @version 1.0.0
     * @param arr массив
     * @return максимальное значений
     */
    public static double maxDoubleArray(double[] arr) {
        double result = Double.MIN_VALUE;
        for (double i : arr)
            if (i>result) result=i;
        return result;
    }

    /**
     * Функция перемножения двумерного массива double и вктора
     * @version 1.0.0
     * @param x массив
     * @param y вектор
     * @return результат в виде одномерного массива
     */
    public static double [] arrayMulVector(double[][] x,double[] y) {
        double [] z = new double[x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i] += x[i][j]*y[j];
        return z;
    }

    /**
     * Функция перемножения двух двумерных массивов double
     * @version 1.0.0
     * @param x массив
     * @param y массив
     * @return результат в виде двумерного массива
     */
    public static double[][] arrayMulVector(double[][] x,double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] += x[i][k]*y[k][j];
        return z;
    }

}
