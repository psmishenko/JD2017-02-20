package by.it.vedom.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Владислав on 02.03.2017.
 */
public class Task2 {

    public static double calculate (double a, double x) {
        double y;
        y = acos(pow(x, 2)) + a*sqrt(x/pow(a, 3)) + pow(sin(PI/2), 3) / log10(2*x);
        return y;
    }
}
