package by.it.korzun.jd01_02;

import java.util.Scanner;

class TaskB {

    void run(){
        System.out.println("Введите значения k, n и m через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String []strArr = line.split(" ");
        int []intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        int k = intArr[0];
        int n = intArr[1];
        int m = intArr[2];
        if(k > n && k < m){
            System.out.println("k принадлежит интервалу (n, m)");
        }else {
            System.out.println("k не принадлежит интервалу (n, m)");
        }

        double kSqr = Math.pow(k, 2);
        int [][]matrix = new int[k][k];
        int count = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("Введите значения a, b и c через пробел: ");
        String lineUr = scanner.nextLine();
        String [] strArrUr = lineUr.split(" ");
        int [] intArrUr = new int[strArrUr.length];
        for (int i = 0; i < strArrUr.length; i++) {
            intArrUr[i] = Integer.parseInt(strArrUr[i]);
        }

        int a = intArrUr[0];
        int b = intArrUr[1];
        int c = intArrUr[2];

        double d = Math.pow(b, 2) - 4*a*c;
        double res1 = (-b + Math.sqrt(d))/(2*a);
        double res2 = (-b - Math.sqrt(d))/(2*a);

        if(d == 0) {
            System.out.println("Корень уравнения: " + res1);
        }else {
            System.out.println("Корни уравнения: " + res1 + ", " + res2);
        }

        int nMonth;
        while(true) {
            System.out.println("Введите число от 1 до 12: ");
            String nStrMonth = scanner.next();
            try {
                nMonth = Integer.parseInt(nStrMonth);
            }catch (Exception e){
                System.out.println("Некорректный ввод");
                continue;
            }
            if(nMonth >= 1 && nMonth <= 12){
                break;
            }else {
                System.out.println("Некорректный ввод");
            }
        }

        switch (nMonth){
            case 1: {
                System.out.println("Январь");
                break;
            }
            case 2: {
                System.out.println("Февраль");
                break;
            }
            case 3: {
                System.out.println("Март");
                break;
            }
            case 4: {
                System.out.println("Апрель");
                break;
            }
            case 5: {
                System.out.println("Май");
                break;
            }
            case 6: {
                System.out.println("Июнь");
                break;
            }
            case 7: {
                System.out.println("Июль");
                break;
            }
            case 8: {
                System.out.println("Август");
                break;
            }
            case 9: {
                System.out.println("Сентябрь");
                break;
            }
            case 10: {
                System.out.println("Октябрь");
                break;
            }
            case 11: {
                System.out.println("Ноябрь");
                break;
            }
            case 12: {
                System.out.println("Декабрь");
                break;
            }

        }
    }
}
