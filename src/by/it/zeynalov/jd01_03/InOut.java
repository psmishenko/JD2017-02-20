package by.it.zeynalov.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InOut {
    public static String console() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String out = input.readLine();
        input.close();
        return out;
    }

    /**
     * Этот метод занимется вводом одномерного массива с консоли
     * @return
     */
    public static double[] input1DArray() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива");

        int size = input.nextInt();
        double array[] = new double[size];

        System.out.println("Введите данные для массива");

        for (int i = 0; i < size; i++) {
            array[i] = input.nextDouble();
        }
        return array;
    }

    /**
     * Этот метод занимется вводом двухмерного массива с консоли
     * @return
     */
    public static double[][] input2DArray() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество строк массива");

        int sizeY = input.nextInt();

        System.out.println("Введите количество столбцов для массива");

        int sizeX = input.nextInt();
        double array[][] = new double[sizeY][sizeX];

        System.out.println("Введите данные для массива построчно");

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        return array;
    }


    /**
     * Этот метод занимется выводом одномерного массива
     * @return
     */
    public static void arrayPrint1D(double[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.printf("%f ", mass[i]);
        }
        System.out.println();
    }

    /**
     * Этот метод занимется выводом двухмерного массива
     * @return
     */
    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++)
                System.out.printf("%6.2f ", m[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printInfo(){
        System.out.println("---------------------------------");
    }
}

