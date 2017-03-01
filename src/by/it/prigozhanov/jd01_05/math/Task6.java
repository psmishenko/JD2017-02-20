package by.it.prigozhanov.jd01_05.math;
import static java.lang.Math.*;
/**
 * Created by v-omf on 3/1/2017.
 */
public class Task6 {
    static void calculate(double e, double b) {
        double[] arr = new double[30];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = pow(e, 2*b+1);
        }
    }
}
