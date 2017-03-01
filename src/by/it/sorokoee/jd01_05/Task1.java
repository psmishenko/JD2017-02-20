package by.it.sorokoee.jd01_05;
import static java.lang.Math.*;
public class Task1 {
    public static double optA(double a,double b){
        double s=(tan(sqrt(a+b)));
        double d=pow((a+1.5),3);
        double f=a*pow(b,5);
        double g=b/log((sqrt(a)));
        double x=s-d+f-g;
        return  x;

    }
    public static double optB(double a,double b){
       double x=(tan(sqrt(a+b)))-pow((a+1.5),3)+a*pow(b,5)-b/log((sqrt(a)));
       return x;
    }
}
