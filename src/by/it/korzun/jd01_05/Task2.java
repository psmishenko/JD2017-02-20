package by.it.korzun.jd01_05;

import static java.lang.Math.*;
class Task2 {
    static double run(double x, double a){
        double z = 1/tan(pow(x, 2)) + pow(cos(PI/2 - a), 3)/abs(x - pow(a, 1/5));
        return z;
    }
}
