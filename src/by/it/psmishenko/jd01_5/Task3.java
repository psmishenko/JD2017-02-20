package by.it.psmishenko.jd01_5;

import static java.lang.Math.tan;
import static java.lang.Math.pow;

public class Task3 {
    public static void printTable(double x){
        System.out.println("#3:----------------");
        System.out.printf("%-8s|%8s \n","a","y");
        System.out.println("------------------");
        for (double a = 3.5; a <=25.5 ; a+=3.75) {
           double y = (1.0/tan(pow(x,3)))+2.24*a*x;
           System.out.printf("%-4.4f  |  %-4.4f \n",a,y);
        }
    }


}
