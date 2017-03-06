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


        //1 условие
        do {
            if (p - 1 < 0) {
                z = p - 3.18 * cos(p + 1);
                System.out.println("Первое условие z = " + z);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.println("Первое условие y = " + y);
            }
            if (0 <= (p - 1) && (p - 1) < 3) {
                z = pow(p , 3) - tan(p);
                System.out.println("Второе условие z = " + z);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.println("Первое условие y = " + y);
            }
            if (p - 1 >= 3){
                z = pow((p + sin(PI/6)) ,5);
                System.out.println("Третье условие z = " + z);
                y = sqrt(abs((z - 2.56 * r)));
                System.out.println("Первое условие y = " + y);
            }
            p += 1.5;
        } while (p > -2 && p < 15);


    }
}
