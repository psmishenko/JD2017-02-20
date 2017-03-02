package by.it.smirnov.jd01_05.math;


/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
import static java.lang.Math.*;

public class Task4 {
    public static double calculate(double fromValue, double toValue, double step) {
        double a = fromValue;
        double result = 0;
        while (a <= toValue) {
            double y = 0;
            for (int x = 1; x <= 6 ; x++)
                y += pow(7,a) - cos(x);
            System.out.printf("a = %2.1f; y = %6.2f%n",a,y);
            result += y;
            a += step;
        }
        return result;
    }
}
