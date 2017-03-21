package by.it.sorokoee.jd01_05.math;

import static java.lang.Math.*;

public class Task4 {

    public static double calculate() {
        double pr = 1;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double i = 2.0; i <= 8.0; i++) {
                double k = pow(E, i) - 2.11 * a;
                pr *= k;
            }
        }
        return pr;
    }

}
