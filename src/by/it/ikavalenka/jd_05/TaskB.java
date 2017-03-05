package by.it.ikavalenka.jd_05;

/**
 * Created by USER on 02.03.2017.
 */
public class TaskB {
    public static double function(double a,double b){
        double y;
        y = Math.tan(Math.pow((a+b),2)) - Math.pow(Math.sqrt(a+1.5),3) + a*Math.pow(b,5) - b/Math.log(Math.pow(a,2));
        return y;
    }
}
