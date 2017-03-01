package by.it.sorokoee.jd01_02;

import java.util.Scanner;

public class Util {
    public static String consoleReadLine()  {
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        return res;
    }

    public static int [] lineToIntArray(String line) {
        line = line.trim();
        String[] strArr = line.split(" ");
        int[] arr = new int [strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;

    }


}
