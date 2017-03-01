package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task5 {
    static void calculate() {
        double l;
        double y;
        System.out.println("Первое условие");
        for (double x = -1.8; x <= -1; x += 0.2) {
            l = asin(x * x);
            y = l / 3 + sqrt(l);
            System.out.printf("x=[%2.1f] l=[%3.2f]  y=[%2.3f]", x, l, y);
            System.out.println();
        }
        System.out.print("Второе условие");
        System.out.println("");
        for (double x = -1; x <= 0.2; x += 0.2) {
            l = acos(x * x);
            y = l / 3 + sqrt(l);
            System.out.printf("x=[ %-4.1f ] l=[%3.2f]  y=[%2.3f]", x, l, y);
            System.out.println();
        }

        System.out.println("Третье условие");
        double x = 0.2;
        l = atan(x * x);
        y = l / 3 + sqrt(l);
        System.out.printf("x=[ %2.1f ] l=[%3.2f]  y=[%2.3f]", x, l, y);
        System.out.println();
    }
}
