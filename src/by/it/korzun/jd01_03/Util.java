package by.it.korzun.jd01_03;


class Util {
    /**
     * Сортировка массива чисел с плавающей точкой
     * @param arr Сортируемый массив
     */
    static void sort(double[] arr){
        boolean swap;
        int last = arr.length - 1;
        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(arr[i] > arr[i+1]){
                    double buff = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                    swap = true;
                }
            }
            last--;
        }while (swap);

    }

//    /**
//     * Произведение матрицы и вектора из чисел с плавающей точкой
//     * @param x Первая матрица
//     * @param y Вектор
//     * @return Возвращает получившуюся матрицу
//     */
//    static double[] arrayMulVector(double[][] x, double[] y){
//        double[] z = new double[x.length];
//        for (int i = 0; i < x.length; i++) {
//            for (int j = 0; j < y.length; j++) {
//                z[i] = z[i] + x[i][j] * y[j];
//            }
//        }
//        return z;
//    }

    /**
     * Произведение матриц из чисел с плавающей точкой
     * @param x Первая матрица
     * @param y Вторая матрица
     * @return Возвращает получившуюся матрицу
     */
    static double[][] arrayMulVector(double[][] x, double[][] y){
        double[][] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

    /**
     * Поиск минимального элемента в массиве из чисел с плавающей точкой
     * @param arr Сам массив
     * @return Возвращает минимальный элемент
     */
    static double findMin(double[] arr){
        double min = Double.MAX_VALUE;
        for (double anArr : arr) {
            if (anArr < min) {
                min = anArr;
            }
        }
        return min;
    }

    /**
     * Поиск максимального элемента в массиве из чисел с плавающей точкой
     * @param arr Сам массив
     * @return Возвращает максимальеый элемент
     */
    static double findMax(double[] arr){
        double max = Double.MIN_VALUE;
        for (double anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }
        return max;
    }
}
