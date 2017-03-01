package by.it.vedom.jd01_03;

import java.util.Scanner;

/**
 * Created by Владислав on 24.02.2017.
 */

public class InOut {

    static  String consoleReadLine() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        return result;
//        return new Scanner(System.in).nextLine();
    }

    /**
     *
     * @param line входная строка
     * @return дабл массив
     */
    static double[] readDoubleArrayFromLine(String line) {
        line = line.trim();
        String[] strValues = line.split(" ");
        double[] result = new double[strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            result[i] = Double.parseDouble(strValues[i]);

        }
        return result;
    }

    /**
     *
     * @param sizeOfVector размер вектора
     * @param name имя на экране
     * @return массив
     */

    static double[] initDoubleArray (int sizeOfVector, String name) {
        Scanner scanner = new Scanner(System.in);
        double array[] = new double[sizeOfVector];
        for (int i = 0; i < sizeOfVector; i++) {
                array[i] = scanner.nextDouble();
        }
        scanner.close();
        return array;
    }

    /**
     *
     * @param arr входной массив
     * @param name  имя на экране
     * @param countCols кол-во столбцов
     */

    // static, т.к не создаем экзмепляр класса в мейне
    static void printDoubleArray (double[] arr, String name, int countCols) {
        System.out.println("Array "+name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d] = %-10.3f", name, i, arr[i]);
            if((i+1)%countCols == 0) {
                System.out.println();
            }
        }
    }

    /**
     *
     * @param row столбец
     * @param col колонка
     * @param name имя на экране
     * @return матрицу
     */

    //Ввод матрицы c клавиатуры и вывод
    static double[][] initDoubleMatrix (int row, int col, String name) {
        Scanner scanner = new Scanner(System.in);
        double matrix[][] = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    /**
     *
     * @param matrix входная матрица
     * @param name  имя на экране
     */

    //Только вывод матрицы
    static void onlyPrintDoubleMatrix (double [][] matrix, String name) {

        System.out.println("Ваша матрица " +name);
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                temp++;
                System.out.printf("%s[%d][%d] = %-10.3f", name, i, j, matrix[i][j]);
                if(temp == 4) {
                    System.out.println();
                    temp = 0;
                }
            }
        }
        System.out.println();
    }


}
