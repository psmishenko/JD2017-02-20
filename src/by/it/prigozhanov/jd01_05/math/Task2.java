package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task2 {
    static double calculate(double x, double a) {
        double z;
        z = atan(x * x) + pow(cos(PI / 2 - a), 3) / (abs((x - pow(a, 1 / 5))));
        return z;
    }
}
