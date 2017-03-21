package by.it.vedom.jd01_02;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by Владислав on 25.02.2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException {

        String line = "1 2 44 5212 51 224 251 22";
        int arr[] = Util.transformLineToIntArray(line);

        //Найти самое короткое и самое длинное числа. Вывести данные числа и их длину.
        System.out.println("---------------------------------------------------");
        System.out.println("Задания А");
        System.out.println("Максимум и минимум в массиве:");
        String max = TaskA.getMax(arr);
        System.out.println(max);
        String min = TaskA.getMin(arr);
        System.out.println(min);


        // Вывести на консоль те числа, длина которых меньше среднего арифметического.
        double mean = TaskA.mean(arr);
        System.out.print("Числа, которое меньше " + mean + ": ");
        for (int i : arr) {
            if (i < mean)
                System.out.print(i + " ");
        }
        System.out.println();

        // Найти число, состоящее только из различных цифр. Если их несколько - вывести первое.
        for (int i : arr) {
            if(TaskA.isDigitsDifferent(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
        break;
    }
}

        System.out.println("---------------------------------------------------");
        System.out.println("Задания B");
        // Определить принадлежность числа k интервалу [N,M]
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое значение интервала N: ");
        double n = scan.nextDouble();
        System.out.print("Введите первое значение интервала M: ");
        double m = scan.nextDouble();
        System.out.print("Введите число для поиска в интервале между N и M: ");
        double k = scan.nextDouble();
        if(TaskB.accessory(n,m,k))
            System.out.println("Число входит в заданный интервал!");
        else System.out.println("Число не входит в заданный интервал!");
        System.out.println();

        // Вывести числа от 1 до k в виде матрицы [N*N], слева направо и сверху вниз
        //k выбрать квадратом целого числа
        System.out.print("Введите число, которое является квадратом целого числа для построения матрицы: ");
        int kForMatrix = scan.nextInt();
        TaskB.matrixFromOneToK(kForMatrix, "A");
        System.out.println();


        //Найти корни квадратного уравнения.
        double a, b, c, D;
        Scanner in = new Scanner(System.in);
        System.out.println("Решение квадратного уравнения вида: ax^2 + bx + c = 0");
        System.out.print("Введите a, b, c: ");
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();

        D = b*b - 4*a*c;
        if(D > 0) {
            double x1 = (-b - Math.sqrt(D))/(2*a);
            double x2 = (-b + Math.sqrt(D))/(2*a);
            System.out.println("Корни уравнения: x1 = " +x1+ ", x2 = " +x2);
        }

        else if (D < 0) {
            double x = -b/(2*a);
            System.out.println("Корень уравнения: x = " +x);
        }

        else System.out.println("Уравнение не имеет корней");


        //Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
        //Осуществить проверку ввода чисел.
        System.out.println();
        System.out.print("Введите число, для установления месяца: ");
        int number = scan.nextInt();
        String month = TaskB.nameMonth(number);
        System.out.println(month);

        Date date = new Date();
        System.out.println("Текущая дата и время ");
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        System.out.println(format.format(date));
        System.out.println();


        System.out.println("---------------------------------------------------");

//        System.out.println("Задания C");


        System.out.println("Задания C");

    }
}

