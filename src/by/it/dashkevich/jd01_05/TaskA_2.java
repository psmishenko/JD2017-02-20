package by.it.dashkevich.jd01_05;

/**
 * Created by дёня on 05.03.2017.
 */
public class TaskA_2 { //13 var
    public static void main(String[] args) {
        double a =  0.94*Math.pow(0.94, -3);
        double x = 10.093;
        double z;

        z = Math.acos(x*x) - a*Math.sqrt(x/Math.pow(a, 3)) + Math.pow(Math.PI/2, 3)/Math.log10(2*x);

        System.out.println(z);  // почему-то выводит NaN, не понял в чем дело

    }
}
