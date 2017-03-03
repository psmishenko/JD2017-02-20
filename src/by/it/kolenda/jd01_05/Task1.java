package by.it.kolenda.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    public static double optionA(double x){
        //с разбивкой выражения на части

        double a=1.21;
        double b=0.371;

        double A = tan(pow(a+b, 2));
        double B = pow(a+1.5, 1.0 / 3);
        double C = pow(b, 5)*a;
        double D = b / log(pow(a, 2));

        x = A - B + C - D;

        return x;
    }

    public static double optionB(double x){
        //одним выражением
        double a=1.21;
        double b=0.371;

        x = tan(pow(a+b, 2)) - pow(a+1.5, 1.0 / 3) + pow(b, 5)*a - b / log(pow(a, 2));

        return x;
    }

}
