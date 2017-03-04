package by.it.kolenda.jd01_05;

import static java.lang.Math.*;

         public class Task3 {
            public static void function3() {
                double t = 2;
                double y;

                int i;
                for (i = 0; i <= 10; i++) {

                    y = log(abs(1.3 + t)) - pow(E, t);
                    System.out.printf("y=%-7.3f t=%3.1f\n",y,t);
                    //t=round((t+0.1)*10.0)/10.0;
                    t=t+0.1;
                }
            }
        }
