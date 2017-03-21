package by.it.zeynalov.jd01_05;

import static java.lang.Math.*;

public class Task2 {

   public static double optionC(double x) {
        double y;
        y = (pow(sin(x + 1), 2) + x * pow(3 + pow(x, 2), 1.0 / 4.0)) / atan(x / 2.0);
        return y;
    }
}
