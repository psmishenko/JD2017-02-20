package by.it.dashkevich.jd01_05;

/**
 * Created by дёня on 07.03.2017.
 */
public class TaskA_3 {
    public static void main(String[] args) {
        // variant 13!!!!
        double y;
        double x =12.1;
        double a;

        for( a=-5; a<=12; a+=3.75) {
            y = Math.pow(Math.E, a*x)-3.45*a;
            System.out.printf("if a = %.3f y = %5.3f \n",a, y);
        }
    }
}
