package by.it.sorokoee.jd01_05.math;
import static java.lang.Math.*;
public class Task5 {
    public static void functionCalcul(double r){
        double x;
        for (double p =0.51; p <20 ; p+=3.5) {
            if(sqrt(p)<5){
                x=pow(sin(p),5);
            } else if (sqrt(p)>=5&&sqrt(p)<13){
                x=pow(7,p+3);
            } else  if(sqrt(p)>13){
                x=log(abs(pow(p+4.7,5)));
            } else continue;
            double z=x+r/2;
            System.out.println(String.format("%6.2f% 6.2f", p,z ));
        }
    }
}
