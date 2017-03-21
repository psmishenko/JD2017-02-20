package by.it.zeynalov.jd01_05;

public class Task4 {

    public static double optionE(double a){
        double summa = 0;

        for (double b = 0.2; b <= 0.4; b += 0.02){
            for (int c = 1; c <= 12; c++){
                double x = c - b;
                summa = summa + x;
            }
        }
        return 1.38 * a + summa;
    }
}

