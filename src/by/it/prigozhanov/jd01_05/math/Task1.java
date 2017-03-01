package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task1 {
    static double OptionA(double a, double b) {
        double y;
        y = pow(cos(PI / 4), 4) + pow(a + 1.5, 1 / 5) + pow((a * b), 8) - b / (log(abs(a * a)));
        return y;
    }
}
