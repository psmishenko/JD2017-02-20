package by.it.psmishenko.jd01_5;


public class Task4 {
    static double calcZ(double a) {
        double zt = 0;
        for (double b = 0.2; b <=0.4 ; b+=0.02) {
            for (int c = 1; c <=12 ; c++) {
                 zt+= c-b;
            }
        }
       double z = zt +1.38*a;
        return z;
    }
}
