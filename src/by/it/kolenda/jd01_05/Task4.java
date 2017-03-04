package by.it.kolenda.jd01_05;
import static java.lang.Math.*;

public class Task4 {
    public static double summa() {
        double w = 0;
        for (int x = 1; x <= 8; x++) {
            for (int i = 6; i <= 11; i++) {
                w = w + pow(x, 5 + 1.3 * i);
            }
//            System.out.printf("%-26.4f\n",w);
        }
//        System.out.println(w);
        return w;
    }
}