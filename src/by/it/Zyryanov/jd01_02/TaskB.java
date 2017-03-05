package by.it.Zyryanov.jd01_02;


public class TaskB {








    //Задание 1 Принадлежность к интервалу


     static void interval(int n, int m , int k) {
         if (k <= m && k >= n)
            System.out.println("Число попадет в интервал");
        else if (k >= m && k <= n)
            System.out.println("Число попадает в интервал");
        else
            System.out.println("Число не попадает в интервал");

    }
    //Задание 1


    //Задание 2 Вывод чисел от 1 до к (квадрат целого числого) в виде матрицы

    static void matrixBuilder(int k){

        int p = 1;
        for (int i = 1; i <= k*k ; i++) {
            System.out.printf("%-5d", i);
            if (i == k * p){
                System.out.println();
                p++;
            }
        }
    }
    //Задание 2


    //Задание 3

    static void quadEquation(double a, double b, double c){

        double D = b*b - 4*a*c;
        System.out.println("Дискриминант = " + D);

        if (D < 0){
            System.out.println("Уравнение не имеет корней.");
        } else if (D == 0) {
            System.out.println("Уравнение имеет один корень.");
            double x = -b / 2 * a;
            System.out.println("x1 и x2 = " + x);
        } else if (D > 0) {
            System.out.println("Уравнение имеет два корня ");
            double x1 = (-b - Math.sqrt(D)) / (2 * a);
            double x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println(" x1 = " + x1 + " x2 = " + x2);
        }
    }

    //Задание 3


    //Задание 4

    static void whatMonth(int p) {

        if (p == 1){
            System.out.println("Январь");
        } else if (p == 2) {
            System.out.println("Февраль");
        } else if (p == 3) {
            System.out.println("Март");
        } else if (p == 4) {
            System.out.println("Апрель");
        } else if (p == 5) {
            System.out.println("Май");
        } else if (p == 6) {
            System.out.println("Июнь");
        } else if (p == 7) {
            System.out.println("Июль");
        } else if (p == 8) {
            System.out.println("Август");
        } else if (p == 9) {
            System.out.println("Сентябрь");
        } else if (p == 10) {
            System.out.println("Октябрь");
        } else if (p == 11) {
            System.out.println("Ноябрь");
        } else if (p == 12) {
            System.out.println("Декабрь");
        } else if (p > 12 || p < 1){
            System.out.println("Всего 12 месяцев в году!");
        }
    }

    //Задание 4

    }

