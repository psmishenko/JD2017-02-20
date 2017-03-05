package by.it.radivonik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Radivonik on 05.03.2017.
 */
public class Task6 {
    public static void calc(double f1, double f2, int col) {
        double[] a = new double[col];
        double f = f1;
        double df = abs((f2 - f1) / (col - 1));

        for (int i = 0; i < a.length; i++) {
            a[i] = cos(f/2);
            f = f + df;
        }
        InOut.arrayPrint(a,"A",5);

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 && (i % 2) > 0) {
                c++;
            }
        }
        double[] b = new double[c];
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] < 0 && (i % 2) > 0) {
                b[j] = a[i];
                j++;
            }
        }
        System.out.println("\nОтрицательные элементы с нечетным индексом:");
        InOut.arrayPrint(b,"B",5);

        double m = 1;
        for (int i = 0; i < b.length; i++) {
            m = m * b[i];
        }
        System.out.printf("\nПроизведение элеиментов массива B: %10.6f",m);

        System.out.println();
    }
}
