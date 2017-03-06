package by.it.zeynalov.jd01_03;

public class Util {

    public static double maxArray(double[] maxMass) {

        /**
         * Метод на нахождение маскимального значения
         * @return
         */
        if (0 == maxMass.length) {
            return Double.MAX_VALUE;
        } else {
            double max = maxMass[0];
            for (double m : maxMass) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    /**
     * Метод на нахождение минимального значения
     * @return
     */
    public static double minArray(double[] minMass) {

        if (0 == minMass.length) {
            return Double.MIN_VALUE;
        } else {
            double min = minMass[0];
            for (double m : minMass) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    /**
     * Метод сортировки массива пузырьком
     * @return
     */
    public static void bubbleSort(double[] massBubble) {

        printMas(massBubble);
        boolean swap;
        double last = massBubble.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (massBubble[i] > massBubble[i + 1]) {
                    double buffer = massBubble[i];
                    massBubble[i] = massBubble[i + 1];
                    massBubble[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        printMas(massBubble);
    }

    public static void printMas(double massive[]) {
        for (double m : massive)
            System.out.print(m + " ");
        System.out.println();
    }

    /**
     * Метод умножения матрицы на вектор
     * @return
     */
    public static double[] arrayVector(double[][] x, double[] y) {
        double[] z = new double[x.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i] = z[i] + x[i][j] * y[j];
        return z;
    }

    /**
     * Метод умножения матрицы на матрицу
     * @return
     */
    public static double[][] arrayMatrix(double[][] x, double[][] y) {
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y[0].length; j++)
                for (int k = 0; k < y.length; k++)
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
        return z;
    }
}
