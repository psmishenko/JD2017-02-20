package by.it.smirnov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
public class Task5 {
    public static void calculate(double fromValue, double toValue, double step) {
        double x = fromValue + step;
        while (x < toValue) {
            double b = 0;
            if ((x/2 > -2) && (x/2 <= -1)) b = sin(pow(x,2));
                else if ((x/2 > -1) && (x/2 < 0.5)) b = cos(pow(x,2));
                    else if (x/2 == 0.2) b = 1/tan(pow(x,2));
            double a = log10(abs(b+2.74));

            System.out.printf("x = %5.2f; b = %5.2f; a = %5.2f%n", x, b, a);
            x += step;
        }
    }
}
