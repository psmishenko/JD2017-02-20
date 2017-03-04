package by.it.prigozhanov.jd01_03;

/**
 * Created by Vladimir on 24.02.2017.
 */
public class Util {

    static void sort(double[] arr) {
        boolean swap; //признак сортированности
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;

                }

            }
            last--;
        } while (swap);
    }

    public static void getMaxValue(double[] arr) {
        System.out.println();
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.print("Max = " + max);
    }

    public static void getMinValue(double[] arr) {
        System.out.println();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Min = " + min);
    }

    public static void matrixMultipliedByVector(double arr[][], double vector[][]) {
        double[][] multarr = new double[arr.length][1];
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum = arr[i][j] * vector[j][0] + sum; // находим сумму перемноженных элементов первой строки на вектор
                multarr[i][0] = sum; // присваивается сумма элеметов первой строки;
            }
            sum = 0;  // счётчик суммы строки обнуляется
        }
        System.out.println("Matrix Multiplied by Vector");
        InOut.printArray2D(multarr, "V");
    }

    public static void matrixMultipliedByMatrix(double firstarr[][], double secondarr[][]) {
        double[][] multarr = new double[firstarr.length][secondarr[0].length];
        for (int i = 0; i < firstarr.length; i++) {
            for (int j = 0; j < secondarr[0].length; j++) {
                for (int k = 0; k < secondarr.length; k++) {
                    multarr[i][j] += firstarr[i][k] * secondarr[k][j];
                }
            }

        }
        System.out.println("Matrix Multiplied by Matrix");
        InOut.printArray2D(multarr, "M");
    }
}