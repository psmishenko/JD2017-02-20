package by.it.zeynalov.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    public static double optionA() {

        double a = 5.8;
        double x = 3.24;

        double b = atan(pow(x, 2));
        double c = sqrt(x + pow(1.43, 3));
        double d = pow(cos(PI / (2 * a)), 3);
        double e = abs(x - (pow(a, 1.0 / 5.0)));

        double z = b - c + d / e;
        return z;
    }

    public static double optionB() {

        double z = atan(pow(3.24, 2)) - sqrt(3.24 + pow(1.43, 3)) + pow(cos(PI / (2 * 5.8)), 3) / abs(3.24 - (pow(5.8, 1.0 / 5.0)));
        return z;
    }
}
