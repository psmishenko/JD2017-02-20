package by.it.kolenda.jd01_05;

import static java.lang.Math.*;

public class Task2 {

    public static double function(double x, double a){
        double z;
        z = -1*pow(x*pow(a,3), 0.5)+log(abs((a-1.12*x)/4));
        return z;
    }
}
