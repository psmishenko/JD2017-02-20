package by.it.smirnov.jd01_05;

import by.it.smirnov.jd01_05.math.*;

/**
 * Created by aleksey.smirnov on 01.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        {
            double x = 234.1;
            System.out.println("Контрольное задание №1");
            System.out.println("x = " + x);
            System.out.println("С разбивкой выражения на части у = " + Task1.optionA(x));
            System.out.println("Полным выражением у = " + Task1.optionB(x));
            System.out.println();
        }

        {
            double a = 0.3;
            double b = -21.17;
            System.out.println("Контрольное задание №2");
            System.out.println("a = " + a + "; b = " + b);
            System.out.println("у = " + Task2.calculate(a,b));
            System.out.println();
        }

        {
            double fromValue = 3.5;
            double toValue = 25.5;
            double step = 2.5;
            //double x = 12.1;
            double x = 2.1;
            System.out.println("Контрольное задание №3");
            System.out.println(fromValue + " <= a <= " + toValue + "; delta = " + step+"; x = " + x);
            Task3.calculate(fromValue, toValue, step, x);
            System.out.println();
        }

        {
            double fromValue = 0;
            double toValue = 2;
            double step = 0.2;
            System.out.println("Контрольное задание №4");
            System.out.println(fromValue + " <= a <= " + toValue + "; delta = " + step);
            System.out.println("у = " + Task4.calculate(fromValue, toValue, step));
            System.out.println();
        }

        {
            double fromValue = -6;
            double toValue = 2;
            double step = 0.5;
            System.out.println("Контрольное задание №5");
            System.out.println(fromValue + " < x < " + toValue + "; delta = " + step);
            Task5.calculate(fromValue, toValue, step);
            System.out.println();
        }

        {
            double fromValue = -3;
            double toValue = 2;
            int countElements = 30;
            System.out.println("Контрольное задание №6");
            Task6.calculate(fromValue, toValue, countElements, "D", "Odd");
        }

        {
            int countElemets = 29;
            double minValue = -7;
            double maxValue = -4;
            System.out.println("Контрольное задание №7");
            Task7.calculate(countElemets, minValue, maxValue);
        }

    }
}
