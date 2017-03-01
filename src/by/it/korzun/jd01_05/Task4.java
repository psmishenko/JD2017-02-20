package by.it.korzun.jd01_05;

import static java.lang.Math.*;

public class Task4 {
    static double run(){
        System.out.println("Task 4: ");
        double sum = 0;

        for (int x = 1; x <= 6; x++){
            for (double a = 0; a <= 2; a += 0.2){
                double res = pow(7, a) - cos(x);
                sum += res;
            }
        }
        return sum;
    }
}
