package by.it.radivonik.jd01_03;

/**
 * Created by user on 24.02.2017.
 */
public class Util {
    /**
     * @version 1.0
     * @param ar массив double для сортировки по возрастанию
     */
    public static void sort(double[] ar) {
        boolean swap; // признак сортированности
        int last = ar.length - 1;
        do {
            swap = false;

            for (int i = 0; i < last; i++) {
                if (ar[i] > ar[i+1]) {
                    double buf = ar[i];
                    ar[i] = ar[i+1];
                    ar[i+1] = buf;
                    swap = true;
                }
            }
            last--;
        } while(swap);
    }

    /**
     * @version 1.0
     * @param ar массив double для поиска минимального значения
     * @return минимальное значение из массива, если массив пуст то возвращается Double.MAX_VALUE
     */
    public static double getMin(double[] ar) {
        double res = Double.MAX_VALUE;
        for (double a : ar) {
            if (res > a)
                res = a;
        }
        return res;
    }

    /**
     * @version 1.0
     * @param ar массив double для поиска максимального значения
     * @return максимальное значение из массива, если массив пуст то возвращается Double.MIN_VALUE
     */
    public static double getMax(double[] ar) {
        double res = Double.MIN_VALUE;
        for (double a : ar) {
            if (res < a)
                res = a;
        }
        return res;
    }

    /**
     * @version 1.0
     * @param x двумерная матрица double для умножения
     * @param y одномерный вектор double для умножения
     * @return одномерный вектор double - результат умножения матрицы на вектор
     */
    public static double[] arrayMul(double[][] x, double[] y) {
        double[] res = new double[x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                res[i] = res[i] + x[i][j] * y[j];
        return res;
    }

    /**
     * @version 1.0
     * @param x двумерная матрица double для умножения
     * @param y двумерная матрица double для умножения
     * @return двумерная матрица double - результат умножения матрицы на матрицу
     */
    public static double[][] arrayMul(double[][] x, double[][] y) {
        double[][] res = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    res[i][j] = res[i][j] + x[i][k] * y[k][j];
        return res;
    }

}
