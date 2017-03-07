package by.it.Zyryanov.jd01_05;

import static java.lang.Math.*;

public class Task6 {
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
                    System.out.printf("Нечётный элемент [ %d ] с числом", i);
                    System.out.println();
            }
        }
        System.out.println();
        System.out.println("Количество нечётных элементов: " + counter);

        //Количество нечётных элементов

        System.out.println();

        //Среднее Геометрическое

        double oddNumbers = 1;

//        for (int i = 0; i <= ; i++) {
//
//            if (round(s[i]) > 0) {
//                oddNumbers *= s[i];
//                System.out.println(oddNumbers);
//            }
//        }




        //Среднее Геометрическое
    }
}
