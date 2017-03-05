package by.it.dashkevich.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by дёня on 03.03.2017.
 */
public class TaskB_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(rd.readLine());
        double b = Double.parseDouble(rd.readLine());
        double c = Double.parseDouble(rd.readLine());
        System.out.println(a+"*x*x + "+b+"*x +"+c+"=0");  //выводим уравнение для решения
        result(a, b, c);

    }
    static void result(double a, double b, double c) {  // через дискриминант находим решение

        double diskrim;
        diskrim = b*b -4*a*c;
        if(diskrim<0) {
            System.out.println("there are no result");
        }
        if(diskrim==0) {
            System.out.println("result x = " + (-b/2*a));
        }
        if(diskrim>0) {
            System.out.println("result x1 = " + ((-b+Math.sqrt(diskrim))/2*a));
            System.out.println("result x2 = " + ((-b-Math.sqrt(diskrim))/2*a));
        }

    }
}
