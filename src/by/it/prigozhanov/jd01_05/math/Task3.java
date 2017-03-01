package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task3 {
    static void calculate(double x) {
        double l;
        for (double c = -10; c <= 1; c += 0.5) {
            l = pow(pow(abs(2 * x - c), 3), 0.2) + 0.567;
            System.out.printf("c=[%6.2f ], l=[ %-5.3f ]", c, l);
            System.out.println();
        }
    }
}
