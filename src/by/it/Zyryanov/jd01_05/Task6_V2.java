package by.it.Zyryanov.jd01_05;

import static java.lang.Math.*;

public class Task6_V2 {
    public static void solver(){

        double s [] = new double[20];

        for (int i = 0; i < 20; i++) {
            s[i] = (random()*2.7 - 1.2);
            s[i] = asin(s[i]/2);
            System.out.printf("[ %d ] s = %.2f ", i, s[i]);
            System.out.println();
        }

        System.out.println();

        //Количество нечётных элементов

        int counter = 0;

        for (int i = 0; i < s.length; i++) {
            if (round(s[i]) % 2 != 0) {
                    counter++;
                    System.out.printf("Нечётный элемент [ %d ] с числом %.2f", i, s[i]);
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println("Количество нечётных элементов: " + counter);


        //Количество нечётных элементов

        System.out.println();

        //Среднее Геометрическое

        double res = 0;

        for (int i = 0; i < counter; i++) {
            res = s[i] * s[i + 1];
        }

        res = pow(res, counter);

        System.out.printf("Среднее геометрическое %.10f " , res);
        System.out.println();

        //Среднее Геометрическое
    }
}
