package by.it.vedom.jd01_05;

import static java.lang.Math.PI;
import static java.lang.Math.sin;


public class Task7 {

    public static double[] getArray() {
        int sizeOfArray = 25;
        double a = 2.0;
        double[] array = new double[sizeOfArray];
        for (double x = 0, j = 0; j < sizeOfArray; x += sin(2*PI), j++) {
            array[(int) j] = a*sin(x);
        }
        return array;
    }
}
