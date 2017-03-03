package by.it.smirnov.jd01_05.math;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
import java.util.Random;

import static java.lang.Math.*;

public class Task7 {

    public static void calculate(int countElemets, double minValue, double maxValue) {
        double[] m = new double[countElemets];
        Random r = new Random();
        int countElementsB = 0;
        //System.out.println("Массив M:");
        for (int i = 0; i < m.length; i++) {
            m[i] = round((minValue + (maxValue - minValue) * r.nextDouble())*100)/100.0 ;
            //System.out.printf("%s[% 3d ]=%6.2f%n","M", i, m[i]);
            if (3*abs(m[i])<=i) countElementsB++;
        }
        double[] b = new double[countElementsB];
        int j = 0;
        //System.out.println("Массив B:");
        for (int i = 0; i < m.length; i++)
            if (3*abs(m[i])<=i) {
                b[j]=m[i];
                //System.out.printf("%s[% 3d ]=%6.2f%n","B", j, b[j]);
                j++;
            }
        sortBubbleDesc(b);
        /*
        System.out.println("Отсортированный по убыванию массив B:");
        for (int i = 0; i < b.length; i++) {
            System.out.printf("%s[% 3d ]=%6.2f%n", "B", i, b[i]);
        }
        */

        int countRow = (int)ceil((double)m.length/ceil((double)m.length/7));
        printDoubleArrayRow(m, "M", countRow, 1);
        printDoubleArrayRow(b, "B", 7, 0);

    }

    static String formatStr = " %s[% -3d]=%6.2f ";
    /**
     * Функция форматированной печати значений одномерного массива double
     * @version 1.0.0
     * @param arr массив
     * @param name наименование массива
     * @param countRow количество строк в строке вывода
     * @param typeOut 0 - индекс по столбцу; 1 - индекс по строке
     */
    public static void printDoubleArrayRow(double[] arr, String name, int countRow, int typeOut) {
        System.out.println("Array: " + name);
        int countCol = (int)ceil((double)arr.length/countRow);
        if (countCol == 1) countRow=arr.length;
        int countPos = String.format(formatStr, name , arr.length-1, 0.0).length();

        System.out.print("╔");
        for (int i = 1; i <= countCol; i++) {
            for (int j = 1; j <= countPos; j++) System.out.print("═");
            if (i == countCol)
                System.out.println("╗");
            else
                System.out.print("╤");
        }

        for (int i = 1; i <= countRow; i++) {
            System.out.print("║");
            for (int j = 1; j <= countCol; j++) {

                int indx = 0;
                switch (typeOut) {
                    case 0 : indx = (j-1)*countRow+(i-1);
                        break;
                    case 1 : indx = (i-1)*countCol+(j-1);
                        break;
                }
                if (indx < arr.length)
                    System.out.printf(formatStr, name , indx, arr[indx]);
                else for (int k = 1; k <= countPos; k++) System.out.print(" ");

                if (j == countCol)
                    System.out.println("║");
                else
                    System.out.print("│");
            }
            if (i != countRow) {
                System.out.print("╟");
                for (int j = 1; j <= countCol; j++) {
                    for (int k = 1; k <= countPos; k++) System.out.print("─");
                    if (j == countCol)
                        System.out.println("╢");
                    else
                        System.out.print("┼");
                }
            }
        }

        System.out.print("╚");
        for (int i = 1; i <= countCol; i++) {
            for (int j = 1; j <= countPos; j++) System.out.print("═");
            if (i == countCol)
                System.out.println("╝");
            else
                System.out.print("╧");
        }
    }

    /**
     * Функция сортировки одномерного массива double методом "пузырька" по убыванию
     * @version 1.0.0
     * @param arr массив
     */
    public static void sortBubbleDesc(double[] arr) {
        boolean swap;
        int last = 0;
        do {
            swap = false;
            for (int i = arr.length-1; i > last; i--) {
                if (arr[i]>arr[i-1]) {
                    double buff=arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = buff;
                    swap = true;
                }
            }
            last ++;
        } while (swap);
    }

}
