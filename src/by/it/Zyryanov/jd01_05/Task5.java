package by.it.Zyryanov.jd01_05;

import static java.lang.Math.*;

public class Task5 {
    public static void solver(){

        //p от -2 до 15 с шагом 1,5

        double y;
        double r = 0.491 * pow(10, 4);
        double z = 0;
        double p = -0.5;


        //y = sqrt(abs((z - 2.56 * r)));
        //


        //1 условие
        do {
            if (p - 1 < 0) {
                z = p - 3.18 * cos(p + 1);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.printf("первое условие при p = [ %.1f ] y = %.2f", p, y);
                System.out.println();
            } else if (0 <= (p - 1) && (p - 1) < 3) {
                z = pow(p , 3) - tan(p);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.printf("второе условие при p = [ %.1f ] y = %.2f", p, y);
                System.out.println();
            } else if (p - 1 >= 3){
                z = pow((p + sin(PI/6)) ,5);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.printf("третье условие при р = [ %.1f ] y = %.2f", p, y);
                System.out.println();
            }
            p += 1.5;
        } while (p > -2 && p < 15);


    }
}
