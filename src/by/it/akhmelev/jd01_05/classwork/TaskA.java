package by.it.akhmelev.jd01_05.classwork;

import static java.lang.Math.*;

/**
 * @author i.sukach
 */
public class TaskA {
    static double calcY(double a, double b){
        double part1=tan(pow((a+b),2));
        double part2=pow((1.5+a),1/3);
        double part3=a*pow(b,5);
        double part4=b/log(a*a);
        double y=part1-part2+part3-part4;
        return y;
    }

    static double calcYoneLine(double a, double b){
        double y=(tan(pow((a+b),2)))-(pow((1.5+a),1/3))+(a*pow(b,5))-(b/log(a*a));
        return y;
    }

    static double calcZ(double a, double x){
        double part1=(a-1.12*x)/4;
        double z=-sqrt(x*pow(a,3))+log(abs(part1));
        return z;
    }

}
