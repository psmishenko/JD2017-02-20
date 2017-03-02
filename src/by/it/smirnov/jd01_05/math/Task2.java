package by.it.smirnov.jd01_05.math;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
import static java.lang.Math.*;

public class Task2 {
    public static double calculate(double a, double b) {
        double x = pow(1/tan(PI/4-1),4);
        double y = pow(a+1.5,1/3);
        double z = b/asin(pow(abs(a),2));
        return x + y - z;
    }
}
