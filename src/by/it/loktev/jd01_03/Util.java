package by.it.loktev.jd01_03;

public class Util {

    /**
     * @version 1.0
     * @param arr массив значений double, который надо отсортировать по возрастанию
     */
    static public void sort(double[] arr){
        for ( int i1=0; i1<arr.length-1; i1++ ) {
            // находим минимальное из всех элементов массива от i1 до конца
            int MinIndex=i1;
            double MinValue=arr[MinIndex];
            for (int i2 = i1+1; i2 < arr.length; i2++){
                if (arr[i2]<MinValue)
                {
                    MinValue=arr[i2];
                    MinIndex=i2;
                }
            }
            // если [i1] оказалось не минимальным, переставляем [i1] и минимальное
            if (MinIndex!=i1) {
                double tmp = arr[i1];
                arr[i1] = arr[MinIndex];
                arr[MinIndex] = tmp;
            }
        }
    }

    /**
     * @version 1.0
     * @param arr массив значений double, в котором надо найти минимальное значение
     * @return минимальное значение из массива, либо Double.MAX_VALUE если массив пуст
     */
    static public double findMinValueInArray(double [] arr){
        double minValue=Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            minValue=Math.min(minValue,arr[i]);
        }
        return minValue;
    }

    /**
     * @version 1.0
     * @param arr массив значений double, в котором надо найти максимальное значение
     * @return максимальное значение из массива, либо -Double.MAX_VALUE если массив пуст
     */
    static public double findMaxValueInArray(double [] arr){
        double maxValue=-Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue=Math.max(maxValue,arr[i]);
        }
        return maxValue;
    }

    /**
     * @version 1.0
     * @param x матрица (двумерный массив double), которую надо умножить
     * @param y вектор (одномерный массив double), на который надо умножить
     * @return одномерный массив double, результат умножения матрицы на вектор
     */
    public static double [] arrayMulVector(double [] [] x, double [] y){
        double [] z=new double[x.length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y.length; j++)
                z[i]+=x[i][j]*y[j];
        return z;
    }

    /**
     * @version 1.0
     * @param x матрица (двумерный массив double), которую надо умножить
     * @param y матрица (двумерный массив double), на которую надо умножить
     * @return двумерный массив double, результат умножения матриц
     */
    public static double [] [] arrayMulVector(double [] [] x, double [] [] y){
        double [] [] z=new double[x.length][y[0].length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y[0].length; j++)
                for (int k=0; k<y.length; k++)
                    z[i][j]+=x[i][k]*y[k][j];
        return z;
    }

}
