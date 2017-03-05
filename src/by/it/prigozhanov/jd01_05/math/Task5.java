package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task5 {
    static void calculate() {
        double l;
        double y;
        for (double x = -3; x < 0.3; x += 0.2) {
            if (x > -2 && x <= -1) {
                l = asin(x * x);
                y = l / 3 + sqrt(l);
                System.out.printf("x=[%1.2f] y=[%2.2f]\n",x, y);
            } if (x > -1 && x < 0.2) {
                l = acos(x * x);
                y = l / 3 + sqrt(l);
                System.out.printf("x=[%1.2f] y=[%2.2f]\n",x, y);
            }
            if (x >= 0.2) //remember this question!!
            {
                l = atan(x * x);
                y = l / 3 + sqrt(l);
                System.out.printf("x=[%1.2f] y=[%2.2f]\n",x, y);
            }
        }
    }
}
