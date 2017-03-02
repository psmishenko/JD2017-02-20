package by.it.smirnov.jd01_05.math;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */

import static java.lang.Math.*;

public class Task1 {
    public static double optionA(double x) {
        double a = pow(sin(PI/2+1),2);
        double b = x*pow((3+x*x),1/4);
        double c = pow(tan(pow(x,3)-1),3);
        double d = atan(x/2);
        double e = Math.exp(1.0/17.56)*log(17.56);
        return (a+b-c)/(d-e);
    }

    public static double optionB(double x) {
        return (pow(sin(PI/2+1),2) + x*pow((3+x*x),1/4) - pow(tan(pow(x,3)-1),3)) / (atan(x/2) - Math.exp(1.0/17.56)*log(17.56));
    }
}
