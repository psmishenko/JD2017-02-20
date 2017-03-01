package by.it.smirnov.jd01_04;

/**
 * Created by aleksey.smirnov on 27.02.2017.
 */
public class InOut {
    /**
    * Функция форматированной печати значений двумерного массива double
    * @version 1.0.0
    * @param m массив
    * @param name наименование массива
    */
    public static void arrayPrint2D(double[][] m, String name) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.printf(name+"[%1d,%1d]=%-7.2f",i,j,m[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Функция форматированной печати значений одномерного массива double
     * @version 1.0.0
     * @param arr массив
     * @param name наименование массива
     * @param countCols количество столбцов в строке вывода
     */
    public static void printDoubleArray(double[] arr, String name, int countCols) {
        System.out.println("Array " + name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%10.5f ",name, i, arr[i]);
            if ((i+1)%countCols==0)
                System.out.println();
        }
        System.out.println();
    }


}
