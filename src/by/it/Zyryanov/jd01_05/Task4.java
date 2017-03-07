package by.it.Zyryanov.jd01_05;

import static java.lang.Math.sin;

public class Task4 {

    public static void solver () {

        //t от 1 до 3
        //sin a - 1 * sin a - 2 * sin a - 3
        //a от -5 до 12
        // шаг а 3.75

        double a = -5;
        double d = 0;

            do {
                for (int t = 0; t <= 3; t++) {
                    d = sin((a - t)) * sin((a - t + 1));
                }
                a += 3.75;
            }
                while (a >= -5 && a <= 12);
        System.out.println(d);
    }
}
