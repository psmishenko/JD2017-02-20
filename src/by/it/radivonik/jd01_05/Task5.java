package by.it.radivonik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Radivonik on 05.03.2017.
 */
public class Task5 {
    public static void calc(double a, double p1, double p2, double dp) {
        double y;
        double x;
        double p = p1;
        double pp;

        System.out.printf("%10s  %10s  %10s", "p", "x", "y");
        while (p < p2+ dp/2) {
            pp = 1.5 * p;
            if (pp  < 1.5)
                x = pow(acos(p),2);
            else if (pp >= 1.5 && pp < 3)
                x = pow(E,p) + 3.5;
            else
                x = p + 4.76;
            y = a + 1.39 * x;
            System.out.printf("\n%10.2f  %10.5f  %10.5f", p, x, y);
            p = p + dp;
        }
        System.out.println();
    }
}
