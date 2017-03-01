package by.it.psmishenko.jd01_3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** Класс ввода-вывода массивов
 *
 */

public class InOut {

    /** Метод чтения с консоли строки одномерного массива
     *
     * @return line - строка ввода
     * @throws IOException
     */

    static String consoleReadLine() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        //buf.close();
        return line;
    }

    /** Метод чтения с консоли строк двумерного массива
     *
     * @param n - количество строк массива
     * @return arrLine - массив строк
     * @throws IOException
     */

    static String[] consoleReadMass(int n) throws IOException {// Двумерный
        String[] arrLine = new String[n];
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            arrLine[i] = buf.readLine();
        }
        return arrLine;
    }


    /** Метод преобразования строки массива в массив типа double
     *
     * @param line - строка
     * @return arr - массив типа double
     */
    public static double[] stringLineToDoubleArray(String line) { // одномерный
        line = line.trim(); // удаляем пробелы в начале и в конце
        String[] elemString = line.split(" ");
        int count = elemString.length;
        double[] arr = new double[elemString.length];
        for (int i = 0; i < count; i++) {
            arr[i] = Double.parseDouble(elemString[i]);
        }
        return arr;
    }

    /** Метод преобразования массива строк в двумерный массив типа double
     *
     * @param strArr - массив строк
     * @return arrMass - двумерный массив типа double
     */
        public static double[][] stringMasstoDoubleArray (String[] strArr) {
        String [][] strMass = new String[strArr.length][];
            for (int i = 0; i <strArr.length ; i++) {
                    strArr[i] = strArr[i].trim();
                    strMass[i] = strArr[i].split(" ");
                }
            double[][] arrMass = new double[strArr.length][strMass[0].length];
            for (int i = 0; i <strArr.length ; i++) {
                for (int j = 0; j <strMass[0].length; j++) {
                    arrMass[i][j] = Double.parseDouble(strMass[i][j]);
                }
            }
            return arrMass;
            }


    /** Метод печати одномерного массива типа double
     *
     * @param arr - массив типа double
     * @param name - имя массива
     * @param col - количество столбцов для вывода
     */
    public static void printArray(double[] arr, String name, int col) {
        int n = 0;
        System.out.println("Name - " + name);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-3s[% -3d]=%-4.4f  ", name, i, arr[i]);
            n++;
            if (n % col == 0) {
                System.out.println();
            }
        }
        System.out.println("");
    }

    /** Метод печати двумерного массива типа double
     *
     * @param arr - двумерный массив типа double
     * @param name - имя массива
     */
        public static void printArray(double[][] arr, String name) {
            for (int i = 0; i <arr.length ; i++) {
                for (int j = 0; j <arr[0].length ; j++) {
                    System.out.printf("%-3s[%-2d,%2d] = %-4.4f  ",name,i,j,arr[i][j]);
                }
                    System.out.println("");
            }
        }

}