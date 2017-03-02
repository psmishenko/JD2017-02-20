package by.it.smirnov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
public class Task6 {
    public static void calculate(double fromValue, double toValue, int countElements, String nameArray, String nameArrayOdd) {
        double step = (toValue - fromValue) / (countElements + 1);
        double k = fromValue + step;
        double[] d = new double[countElements];
        int i = 0;
        while (abs(k - toValue) > 0.00001) {
            d[i] = log10(abs(k+6));
            System.out.printf("%s[% 3d ]=%8.5f%n",nameArray, i, d[i]);
            i++;
            k += step;
        }
        double sumOdd = 0;
        System.out.println();
        System.out.println("Вывод элементов массива с нечетными индексами:");
        for (int j = 0; j < d.length; j++)
            if (j%2 != 0) {
                sumOdd += d[j];
                System.out.printf("%s[% 3d ]=%8.5f%n",nameArrayOdd, j, d[j]);
            }
        System.out.printf("Сумма элементов с нечетными индексами: %8.5f%n",sumOdd);
        System.out.println();
    }
}
