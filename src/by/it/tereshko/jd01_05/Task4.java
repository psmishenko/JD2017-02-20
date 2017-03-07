package by.it.tereshko.jd01_05;

import static java.lang.Math.*;

public class Task4 {
    public static double calculate(double a) {

        double sum = 0;

        for (double b = 0.2; b <= 0.4; b += 0.02) {
            for (int c = 1; c <= 12; c++) {
                double x = sqrt(c + b);
                sum += x;
            }
        }
        return 1.38 - a + sum;
    }
}
