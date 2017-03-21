package by.it.tereshko.jd01_05;

import static java.lang.Math.*;

public class Task1 {
    public static double optionA(double z) {
//        выражение отдельными фрагментами
        double a = 0.94;
        double x = 10.093;

        double c = cos(pow(x, 2));
        double d = a * sqrt(x);
        double e = pow(1.0 / cos(PI / 2 + a), 3);
        double f = log(2 * x);

        z = c - d + e / f;
        return z;
    }

    public static double optionB(double z) {
//        выражение одной строкой
        double a = 0.94;
        double x = 10.093;
        z = cos(pow(x, 2)) - a * sqrt(x) + (pow(1.0 / cos(PI / 2 + a), 3) / log(2 * x));
        return z;
    }
}
