package by.it.radivonik.jd01_05;

/**
 * Created by Radivonik on 02.03.2017.
 */
public class Task4 {
    public static void calc(double a, double b1, double b2, double db) {
        double z;
        double s;
        double b = b1;

        System.out.printf("%10s  %10s", "b", "z");
        while (b <= b2) {
            z = 1.38 - a;
            s = 0;
            for (int c = 1; c <= 12; c++) {
                s = s + pow(c + b,2);
            }
            z = z + s;
            System.out.printf("\n%10.2f  %10.5f", b, z);
            b = b + db;
        }
        System.out.println();
    }
}
