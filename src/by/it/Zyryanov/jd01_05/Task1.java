package by.it.Zyryanov.jd01_05;


import static java.lang.Math.*;


public class Task1 {

    public static void solver (double x){

        double y = ( pow(sin((PI/6)-1),2) + pow((3 + pow(x,2)), 1/4) - pow(log((pow(x,3)-1)), 3) ) /
                (asin((x/2)) - 1.756 * pow(10, -2));

        System.out.println("Ответ: " + y);
    }
}
