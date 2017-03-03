package by.it.radivonik.jd01_05;

/**
 * Created by Radivonik on 02.03.2017.
 */
public class Task2 {
    public static double calc(double x, double f) {
        double res;
        res =  (pow(sin(PI/8-f),2) + pow(3+pow(x,2),1/4)) / 2;
        return res;
    }
}
