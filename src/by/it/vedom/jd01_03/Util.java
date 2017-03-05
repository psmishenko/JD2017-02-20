package by.it.vedom.jd01_03;


/**
 * Created by Владислав on 24.02.2017.
 * @author Владислав
 */


public class Util {

    /**
     *
     * @param array входной массив
     */
    static void bubbleSort (double[] array) {

        boolean swap; // признак сортированности
        int last = array.length - 1;
        do {

            swap = false;
            for (int i = 0; i < last; i++) {

                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    /**
     *
     * @param array входной массив
     * @return минимальный элемент массива
     */
    static double getMin (double[] array) {
        double res = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if(array[i] < res) res = array[i];
        }
        return res;
    }

    /**
     *
     * @param array входной массив
     * @return максимальный элемент массива
     */

    static double getMax (double[] array) {
        double res = 0;
        for (Double i: array) {
            if(i > res) res = i;
        }
        return res;
    }

    /**
     *
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return результирующая матрица
     */

    public static double[] matrixMulVector (double[][] matrix, double[] vector) {
        double[] resultMatrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultMatrix[i] += matrix[i][j] + vector[j];
            }
        }
        return resultMatrix;
    }

    /**
     *
     * @param x первая входная матрица
     * @param y вторая входная матрица
     * @return результирующая матрица(результат перемножения двух входных)
     * @return результирующую матрицу(результат перемножения двух входных)
     */

    public static double[][] matrixMulmatrix (double[][] x, double[][] y) {
        double resultMatrix[][] = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    resultMatrix[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return resultMatrix;
    }



}


