package by.it.radivonik.jd01_05;

/**
 * Created by Radivonik on 01.03.2017.
 */

import static java.lang.Math.*;

public class Task1 {
    public static double calc1(double a, double b) {
        double x1 = pow(1/tan(PI/4-1),4);
        double x2 = pow(a+1.5,1/3);
        double x3 = pow(a-b,8);
        double x4 = b/pow(asin(abs(a)),2);
        return x1 + x2 + x3 - x4;
    }

    public static double calc2(double a, double b) {
        double res;
        res =  pow(1/tan(PI/4-1),4) + pow(a+1.5,1/3) + pow(a-b,8) - b/pow(asin(abs(a)),2);
        return res;
    }
}
