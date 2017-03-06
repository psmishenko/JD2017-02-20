package by.it.Zyryanov.jd01_05;

import static java.lang.Math.E;
import static java.lang.Math.pow;


public class Task3 {

    public static void solver (double x){

        double a = 0;
        double f;
        int i = 0;

        while (a >= 0 && a <= 2){

           f = pow(E, pow(a, x)) - 3.45*a;
            a = a + 0.2;
            System.out.println("[ "+ i +" ]  " + f);
            i++;
        }

    }

}
