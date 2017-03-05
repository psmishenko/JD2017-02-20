package by.it.ikavalenka.jd_05;

/**
 * Created by USER on 01.03.2017.
 */

import static java.lang.Math.*;


public class TaskA {
    public static double optionA (double x, double d){
        double e = pow(x, 2);
        double o = PI/6;
        double a = cos(e+o);
        double l = pow(a,5);
        double b = sqrt(x*pow(d, 3));
        double c = log(abs(d-1.12*x)/4);

            x = l - b - c;
            return x;
    }
    public static double optB(double x, double d){
    x = cos(pow((pow(x, 2)+PI/6),5))-sqrt(x*pow(d, 3))-log(abs(d-1.12*x)/4) ;
        return x;
    }
}

