package by.it.ikavalenka.jd_03;

/**
 * Created by USER on 24.02.2017.
 */
public class Unitls {
    static void sort(double[] arr) {
        boolean swap; //признак сортированности
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i] = buff;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    //    public static int[] sortInArray (int[] mas, boolean upDirection){
//        for (int i = 0; i < mas.length ; i++)
//            for (int j = i+1; j < mas.length ; j++)
//                if ((upDirection && mas[i] > mas[j]) ||
//                    (!upDirection && mas[i] < mas [j]))
//                    {
//                        int m = mas [i];
//                        mas [i] = mas [j];
//                        mas [j] = m;
//            }
//                return mas;
//
//    }
    public static double maxInArray(double[] mas) {
        if (0 == mas.length) {
            return Double.MAX_VALUE;
        } else {
            double max = mas[0];
            for (double m : mas) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    public static double minInArray(double[] mas) {
        if (0 == mas.length) {
            return Double.MIN_VALUE;
        } else {
            double min = mas[0];
            for (double m : mas
                    ) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    public static double[] arrMulVec(double[][] z, double[] c) {
        double[] w = new double[z.length];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < c.length; j++) {
                w[i] = w[i] + z[i][j] * c[j];
            }
        }
            return w;
        }


        public static double[][] arrMulVec ( double[][] z, double[][] c){
            double[][] w = new double[z.length][c[0].length];
            for (int i = 0; i < z.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    for (int k = 0; k < c.length; k++) {
                        w[i][j] = w[i][j] + z[i][k] * c[k][j];
                    }
                }
            }
            return w;

    }
}





