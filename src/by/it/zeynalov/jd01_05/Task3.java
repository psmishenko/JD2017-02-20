package by.it.zeynalov.jd01_05;

import static java.lang.Math.*;

public class Task3 {

    public static void optionD() {
        double x = 3.567;
        for (double a = 3.5; a <= 25.5; a += 3.75) {
            double y = 1 / (1.0 / tan(pow(x, 3))) + 2.24 * a * x;
            System.out.printf("optionD: [%6.2f ], [ %-5.3f ]", a, y);
            System.out.println(a + y);

        }
    }
}
