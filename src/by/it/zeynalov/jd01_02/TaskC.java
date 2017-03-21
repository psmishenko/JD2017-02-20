package by.it.zeynalov.jd01_02;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class TaskC {

    public static void equation() {

        Scanner src = new Scanner(in);

        double a, b, c;
        double d;

        System.out.println("Нахождение корней квадратного уравнения");
        System.out.println("Введите зачение а");;
        a = src.nextDouble();
        System.out.println("Введите значение b");;
        b = src.nextDouble();
        System.out.println("Введите значение c");
        c = src.nextDouble();

        d = b * b - a * 4 * c;
        if (d > 0)

        {
            double x1, x2;
            x1 = (-b - Math.sqrt(d)) / (2 * a);
            x2 = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        } else if (d == 0)

        {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        } else

        {
            System.out.println("Уравнение не имеет действительных корней!");
        }

    }

}
