package by.it.sorokoee.jd01_05.math;
import java.util.Scanner;

import static java.lang.Math.*;
public class Task2 {
    public static double optC(double x, double a){
        double z=atan(sqrt(x))+pow(cos(PI/2-a),3)/abs(x-pow((a),1/5));
        return z;
   }
    public static void optD(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введите значение x:");
        double x=scanner.nextDouble();
        System.out.print("Введите значение a:");
        double a=scanner.nextDouble();
        double z=atan(sqrt(x))+pow(cos(PI/2-a),3)/abs(x-pow((a),1/5));
        System.out.println("При x="+x+" и a="+a+" z="+z);
    }

}
