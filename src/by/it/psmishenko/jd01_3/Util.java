package by.it.psmishenko.jd01_3;

/**
 * Класс операций над массивами
 */
public class Util {
    /**
     * Метод определения максимума одномерного массива
     * @param arr - одномерный массив типа double
     * @return max - значение максимума массива
     */
    public static double maxDoubleArray (double[] arr) {
        if(arr.length == 0) {return Integer.MAX_VALUE;}
        else {
            double max = arr[0];
            for (int i = 0; i <arr.length ; i++) {
                if(max<arr[i]) max = arr[i];
            }
            return max;
        }
    }

    /**
     * Метод определения минимума массива типа double
     * @param arr - одномерный массив типа double
     * @return min - значение минимума массива
     */
    public static double minDoubleArray (double[] arr){
        if(arr.length == 0) {return Integer.MIN_VALUE;}
        else {
            double min = arr[0];
            for (int i = 0; i <arr.length ; i++) {
                if(min>arr[i]) min = arr[i];
            }
            return min;
        }
    }

    /**
     * Метод сортировки массива "пузырьком"
     * @param arr - одномерный массив типа double
     * @return arr - отсортированный массив
     */

    public static double[] sortSimpleBubbleDoubleArray (double[] arr) {
        boolean ind;
        int last = arr.length - 1;
        do {
            ind = false;
            for (int i = 0; i <last ; i++) {
                if(arr[i]>arr[i+1]) {
                    ind = true;
                    double buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
            last--;
        }while (ind);
        return arr;
    }

    /**
     * Метод сортировки массива "пузырьком" с выбором направления сортировки
     * @param arr - одномерный массив типа double
     * @param ind - переменная, определяющая направления сортировки ( true - для восходящей, false - для нисходящей)
     * @return arr - отсортированный массив
     */

    public static double[] sortBubbleDoubleArray (double[] arr, boolean ind){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                if( (ind&&(arr[i]>arr[j])) || (!ind&&(arr[i]<arr[j]))) {
                    double buf = arr[i];
                    arr[i]=arr[j];
                    arr[j]=buf;
                }
            }
        }
        return arr;
    }

    /**
     * Метод определения произведения двумерного массива на вектор
     * @param m1 - двумерный массив типа double
     * @param m2 - одномерный массив типа double
     * @return res - одномерный массив (результат произведения)
     */
    public static double[] arrayMulVector (double[][] m1, double[] m2 ) {
        double [] res = new double[m1.length];
        for (int i = 0; i <m1.length ; i++) {
            for (int j = 0; j <m2.length ; j++) {
                res[i]+=m1[i][j]*m2[j];
            }
        }
        return res;
    }

    /**
     * Метод определения произведения двух двумерных массивов
     * @param m1 - двумерный массив типа double
     * @param m2 - двумерный массив типа double
     * @return res - двумерный массив (результат произведения)
     */
    public static double[][] arrayMulArray (double[][] m1, double[][] m2) {
        double [][] res = new double[m1.length][m2[0].length];
        for (int i = 0; i <m1.length ; i++) {
            for (int j = 0; j <m2[0].length ; j++) {
                for (int k = 0; k <m2.length ; k++) {
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}
