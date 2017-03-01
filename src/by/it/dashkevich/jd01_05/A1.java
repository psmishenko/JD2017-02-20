package by.it.dashkevich.jd01_05;

/**
 * Created by дёня on 01.03.2017.
 */
public class A1 {
    public static void main(String[] args) {
        double a = 1.21;
        double b = 0.371;
        System.out.println(result (a, b));

    }

    public static double result(double a, double b) {

        double res = Math.pow(Math.tan(a + b), 2) - Math.pow((a + 1.5), 1/3) + a*Math.pow(b, 5) - b/Math.log10(a*a);
        return res;
    }



}
