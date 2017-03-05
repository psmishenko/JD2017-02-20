package by.it.Zyryanov.jd01_03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InOut {



//    -------------------- Метод ввода данных


    public static String consoleReadLine() throws IOException {

        BufferedReader line = new BufferedReader(new InputStreamReader(System.in));

        String out = line.readLine();
        line.close();
        return out;
    }

    //--------------------


    //-------------------- Статический метод ввода одномерного массива

    public static double[] stringToDoubleArray(String line) {
        line = line.trim();
        String[] elemString = line.split(" ");      //преобразуем строку в массив
        double[] mas = new double[elemString.length];           //
        for (int i = 0; i < elemString.length; i++) {
            mas[i] = Double.parseDouble(elemString[i]);
        }
        return mas;
    }

    //---------------------- Статический метод вывода одномерного массива

    public static void printArray(double[] arr, String name, int cols) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(name + "[% -3d]=%-3.1f ", i, arr[i]);      //печатаем значения,
            col++;
            if (0 == col % cols) {                                 //если конец колонки или конец массива
                System.out.println();                           //Тогда печатаем перевод строки
            }
        }
    }

    //----------------------




    //---------------------- Статический метод вывода двухмерного массива

    public static void printArray2D(double[][] arr, String name, int cols) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) { //перебираем строки массива
            for (int j = 0; j < arr[0].length; j++) { //перебираем столбцы
                System.out.printf(name + "[%1d,%1d]=%-6.1f ", i, j, arr[i][j]);
                col++;
                if (0 == col % cols) {                                 //если конец колонки или конец массива
                    System.out.println();                           //Тогда печатаем перевод строки
                }
            }
        }
    }
    //------------------------

}
