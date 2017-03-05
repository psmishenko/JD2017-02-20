package by.it.Zyryanov.jd01_03;


public class Util {

//-------------------------------------------------
    //сортировка массивов

    public static void arraySort(double [] arr) {
        printMas(arr);
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last ; j++) {
                if (arr[j] > arr[j + 1]){
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        printMas(arr);
    }

//------------------------------------------------
    private static void printMas(double massive[]) {
        for (double arr : massive) System.out.print(arr + " ");
        System.out.println();
    }
//---------------------------------------------------
    //поиск максимального значения в массиве чисел

    public static void maxFinder(double [] arr) {
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Максимальное значение в массиве = " + max);
    }
//----------------------------------------------------
    //поиск минимального значения в массиве чисел

    public static void minFinder(double [] arr) {
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last ; j++) {
                if (arr[j] > arr[j + 1]){
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        System.out.println(arr[0]);
    }
//---------------------------------------------------
    //умножение матрицы на вектор
   public static double[] matrixMulByVector (double[][] m, double [] v) {


           double[] r = new double[m.length];

       for (int i = 0; i < m.length; i++)
           for (int j = 0; j < v.length; j++)
               r[i] = r[i] + m[i][j] * v[j];
       InOut.printArray(r, "r", 1);
       return r;
   }
//---------------------------------------------------
    //умножение матрицы на матрицу

    public static double[][] matrixMulByMatrix (double[][] x, double[][] y) {

        double z [][] = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {  //row повторяется 4 раза
            for (int j = 0; j < y[0].length; j++) { //col повторяется 3 раза
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        InOut.printArray2D(z, "z", 3);
        return z;
    }

//---------------------------------------------------

}
