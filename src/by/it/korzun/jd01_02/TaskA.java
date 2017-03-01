package by.it.korzun.jd01_02;

import java.util.Scanner;

class TaskA {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
        String[] strArr = line.split(" ");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
            System.out.println("intArr[" + i + "] = " + intArr[i]);
        }


        int minLength;
        int maxLength;
        int minLengthPlace = 0;
        int maxLengthPlace = 0;
        minLength = strArr[0].length();
        maxLength = strArr[0].length();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].length() < minLength) {
                minLength = strArr[i].length();
                minLengthPlace = i;
            }
            if (strArr[i].length() > maxLength) {
                maxLength = strArr[i].length();
                maxLengthPlace = i;
            }
        }
        System.out.println(intArr[minLengthPlace] + ": " + minLength);
        System.out.println(intArr[maxLengthPlace] + ": " + maxLength);

        int sum = 0;
        for (int i = 0; i < intArr.length; i++) {
            sum += strArr[i].length();
        }
        System.out.println("Сумма длин: " + sum);
        double srArifm = sum / intArr.length;
        System.out.println("Среднее: " + srArifm);

        System.out.println("Меньше среднего арифмитического:");
        for (int i = 0; i < intArr.length; i++) {
            if (strArr[i].length() < srArifm) {
                System.out.println(intArr[i]);
            }
        }


        System.out.println("Уникальные: ");
        for (int i = 0; i < intArr.length; i++) {
            boolean unic = true;
            char[] temp = strArr[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < temp.length; k++) {
                    if (j != k && temp[j] == temp[k]) {
                        unic = false;
                    }
                }
            }
            if (unic) {
                System.out.println(intArr[i]);
            }
        }
    }
}
