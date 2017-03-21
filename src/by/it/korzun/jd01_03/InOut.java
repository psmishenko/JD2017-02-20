package by.it.korzun.jd01_03;

import java.util.Scanner;

class InOut {
    /**
     * Процедура чтения строки с консоли
     * @return Возвращает строку консоли
     */
    static String consoleReadLine(){
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        return line;
        return new Scanner(System.in).nextLine();
    }

    /**
     *
     * @param line Строка чисел(с плавающей точкой), разделённых пробелами
     * @return Возвращает массив этих чисел
     */
    static double[] readDoubleArrayFromLine(String line){
        line = line.trim();
        String[] strValue = line.split(" ");
        double[] res = new double[strValue.length];
        for (int i = 0; i < strValue.length; i++) {
            res[i] = Double.parseDouble(strValue[i]);
        }
        return res;
    }

    /**
     *
     * @param line Строка чисел(целых), разделённых пробелами
     * @return Возвращает массив этих чисел
     */
    private static int[] readIntArrayFromLine(String line){
        line = line.trim();
        String[] strValue = line.split(" ");
        int[] res = new int[strValue.length];
        for (int i = 0; i < strValue.length; i++) {
            res[i] = Integer.parseInt(strValue[i]);
        }
        return res;
    }

    /**
     * Создаёт матрицу
     * @return Возвращает созданную матрицу
     */
    static double[][] createMatrix(){
        System.out.println("Enter matrix size(n, m):");
        String strSize = consoleReadLine();
        int []intSize = readIntArrayFromLine(strSize);
        int n = intSize[0];
        int m = intSize[1];
        System.out.println("Enter matrix elements:");
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            String line = consoleReadLine();
            double[] res = readDoubleArrayFromLine(line);
            System.arraycopy(res, 0, matrix[i], 0, m);
        }
        return matrix;
    }

    /**
     * Вывод матрицы на консоль
     * @param matrix Матрица для вывода
     */
    static void printMatrix(double[][] matrix){
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%-10.3f", aMatrix[j]);
            }
            System.out.println();
        }
    }

    /**
     * Вывод массива чисел с плавающей точкой на консоль
     * @param arr Массив
     * @param name Имя для массива
     * @param countColls Число столбцов для вывода
     */
    static void printDoubleArray(double[] arr, String name, int countColls){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%s[% -3d]=%-10.3f", name, i, arr[i]);
            if((i+1)%countColls == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
