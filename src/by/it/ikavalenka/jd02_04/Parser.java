package by.it.ikavalenka.jd02_04;

/**
 * Created by USER on 12.04.2017.
 */
public class Parser {
    public static double add (double a, double b){
        double c=a+b;
        return c;
    }
    public static double mul (double a, double b){
        double c=a*b;
        return c;
    }
    public static double prioritymul (double a, double b,double e){
        double c=a+b*e;
        return c;
    }
    public static double divPriority (double a, double b,double e){
        double c=a/b-e;
        return c;
    }
}
