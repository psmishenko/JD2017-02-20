package by.it.tereshko.jd01_05;

import static java.lang.Math.*;

public class Task2 {
    public static double calculate(double x, double a) {

        double z;
        z = atan(sqrt(x)) + pow(1.0 / sin(PI / 2 - a), 3) / (x - pow(a, 0.2));
        return z;

    }
}