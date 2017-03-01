package by.it.sorokoee.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void numberMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца:");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            case 3:
                System.out.println("Март");
                break;
            case 4:
                System.out.println("Апрель");
                break;
            case 5:
                System.out.println("Май");
                break;
            case 6:
                System.out.println("Июнь");
                break;
            case 7:
                System.out.println("Июль");
                break;
            case 8:
                System.out.println("Август");
                break;
            case 9:
                System.out.println("Сентябрь");
                break;
            case 10:
                System.out.println("Октябрь");
                break;
            case 11:
                System.out.println("Ноябрь");
                break;
            case 12:
                System.out.println("Декабрь");
                break;
            default:
                System.out.println("Месяца с таким номером не существует");
        }
    }

    public static void intervalAcces() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значиние k:");
        int k = scanner.nextInt();
        System.out.print("Введите значиние начала интервала:");
        int n = scanner.nextInt();
        System.out.print("Введите значиние конца интервала:");
        int m = scanner.nextInt();

        for (int i = n; i <= m; i++) {
            if (k >= n && k <= m) {

                System.out.println("Значение " + k + " принадлежит заданному интервалу");
                break;
            }


        }
        if (k < n || k > m)
            System.out.println("Значение " + k + " не принадлежит заданному интервалу");


    }

    public static void matrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значиние k:");
        int k = scanner.nextInt();
        System.out.print("Введите значиние n:");
        int n = scanner.nextInt();
        int [][] a=new int[n][n];
        int z=1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                a[i][j]=z;
                System.out.print(a[i][j]+"\t");
                z++;
            }

            System.out.println();
        }
    }
}
