package by.it.psmishenko.jd01_4;

/**
 * Метод вывода одномерных и двумерных массивов
 */
public class InOut {
    /** Метод печати одномерного массива типа double
     *
     * @param arr - массив типа double
     * @param name - имя массива
     * @param col - количество столбцов для вывода
     */
    public static void printArray(double[] arr, String name, int col) {
        int n = 0;
        System.out.println("Вектор "+name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-3s[% -3d]=%-4.4f  ", name, i, arr[i]);
            n++;
            if (n % col == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /** Метод печати двумерного массива типа double
     *
     * @param arr - двумерный массив типа double
     * @param name - имя массива
     */
    public static void printArray(double[][] arr, String name) {
        System.out.println("Матрица "+name);
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {
                System.out.printf("%-4s[%-2d,%2d] = %-4.4f  ",name,i,j,arr[i][j]);
            }
            System.out.println("");
        }
    }
}
