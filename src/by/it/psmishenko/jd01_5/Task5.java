package by.it.psmishenko.jd01_5;
import static java.lang.Math.*;
public class Task5 {
    static void calcBeta (){
        System.out.println("#5: -----------------------");
        double beta = 0;
        for (double x = -6; x < 2 ; x+=0.5) {
            if ((x/2)>-2 &&(x/2)<=-1) beta = sin(pow(x,2));
            else if ((x/2)>-1 &&(x/2)<0.2) beta = cos(pow(x,2));
            else if ((x/2)==0.2) beta = 1/tan(pow(x,2));
            else continue;
            double alpha = log10(abs(beta+2.74));
            System.out.printf("(x)%-4.4f -- %-4.4f(alpha) \n",x,alpha);
        }
    }
}
