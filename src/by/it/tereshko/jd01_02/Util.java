package by.it.tereshko.jd01_02;

import java.io.IOException;
import java.util.Scanner;

public class Util {

    static String getOnline() throws IOException {
        return new Scanner(System.in).nextLine();
    }

    static int[] lineToArray(String line) {
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }
}
