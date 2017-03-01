package by.it.sorokoee.jd01_03;

public class Util {
    public static void sort(double[] array) {
        boolean swap;
        int last = array.length - 1;

        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                    swap = true;
                }

            }
            last--;
        }

        while (swap);
    }
    public static double [] sortDoubleArr(double[] array, boolean upDirection){
        for (int i = 0; i <array.length-1 ; i++) {
            for (int j=i+1; j <array.length ; j++) {
                if((upDirection&&array[i]>array[j])||
                        !upDirection&&array[i]<array[j]){
                    double m=array[i];
                    array[i]=array[j];
                    array[j]=m;

                }

            }

        }
        return  array;
    }

    public static double maxDoubleArray(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m)
                    max = m;
                }
                return max;

            }

        }
    public static double minDoubleArray(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        }
        else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m)
                    min = m;
            }
            return min;

        }

    }
    public static double[][] arrayMulArray(double[][] x, double[][] y){
        double [][] z=new double[x.length][y[0].length];
        for (int i = 0; i <x.length ; i++) {
            for (int j = 0; j <y[0].length ; j++) {
                for (int k = 0; k <y.length ; k++) {
                    z[i][j]+=x[i][k]*y[k][j];

                }

            }

        }
        return  z;
    }
    public  static double[] arrayMulVector( double [][] x, double [] y){
        double [] z=new double[x.length];
        for (int i = 0; i <x.length ; i++) {
            for (int j = 0; j <y.length ; j++) {
             z[i]=z[i]+x[i][j]*y[j];
            }

        }
       return  z;
    }

    }




