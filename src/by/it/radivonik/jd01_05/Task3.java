package by.it.radivonik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Radivonik on 02.03.2017.
 */
public class Task3 {
    public static void calc(double t1, double t2, double dt) {
        double s;
        double t = t1;

        System.out.printf("%10s  %10s", "t", "s");
        while (t <= t2) {
            s = log10(abs(1.3 + t)) - pow(E, t);
            System.out.printf("\n%10.2f  %10.5f", t, s);
            t = t + dt;
        }
        System.out.println();
    }
}
