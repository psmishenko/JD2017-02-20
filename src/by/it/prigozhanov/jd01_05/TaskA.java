package by.it.prigozhanov.jd01_05;

import static java.lang.Math.cos;

/**
 * Created by v-omf on 3/1/2017.
 */
public class TaskA {
    //задача1
    static double Task1(double a, double b) {
        double y;
        y = Math.pow(Math.cos(Math.PI/4), 4) + Math.pow(Math.sqrt(a + 1.5), 1 / 5) + Math.pow((a * b), 8) - b / (Math.log(Math.abs(a*a)));
        return y;
    }

}
