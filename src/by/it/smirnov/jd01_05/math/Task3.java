package by.it.smirnov.jd01_05.math;

import static java.lang.StrictMath.*;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
public class Task3 {
    public static void calculate(double fromValue, double toValue, double step, double x) {
        double a = fromValue;
        while (a <= toValue) {
            System.out.printf("a = %4.1f; y = %5.2f%n",a,asin(x/3)+1.2*a);
            a += step;
        }
    }
}
