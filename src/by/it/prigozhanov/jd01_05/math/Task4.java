package by.it.prigozhanov.jd01_05.math;
import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task4 {
    static void calculate() {
        double m = 1;
        for (int d = 23; d <= 39; d++) {
            for (double t = 2; t <= 3 ; t+=0.1) {
                m*=log((abs(d-t)));
            }
        }
        System.out.println(m);
    }


}
