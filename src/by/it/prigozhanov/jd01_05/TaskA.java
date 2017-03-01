package by.it.prigozhanov.jd01_05;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class TaskA {
    //задача1
    static double Task1(double a, double b) {
        double y;
        y = pow(cos(PI / 4), 4) + pow(sqrt(a + 1.5), 1 / 5) + pow((a * b), 8) - b / (log(abs(a * a)));
        return y;
    }

    //задача 2
    static double Task2(double x, double a) {
        double z;
        z = atan(x * x) + pow(cos(PI / 2 - a), 3) / (abs((x - pow(sqrt(a), 1 / 5))));

        return z;
    }

    //задача 3
    static void Task3(double x) {
        double l;
        for (double c = -10; c <= 1; c += 0.5) {
            l = pow(sqrt(pow(abs(2 * x - c), 3)), 1/5) + 0.567;
            System.out.printf("c=[%6.2f ], l=[ %-5.3f ]", c, l);
            System.out.println();
        }
    }

}
