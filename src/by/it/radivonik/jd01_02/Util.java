package by.it.radivonik.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class Util {
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        stin.close();
        return line;
    }

    static int[] lineToIntArray (String line) {
        String[] strArray = line.split(" ");
        int[] array = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }
}
