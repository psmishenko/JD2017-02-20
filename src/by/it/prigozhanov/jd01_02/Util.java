package by.it.prigozhanov.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by v-omf on 2/22/2017.
 */
public class Util {
    static String GetOneLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        reader.close();
        return line;
    }

    static String GetLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        return line;
    }

    static int[] lineToIntArray(String line) {
        String[] strArr = line.split(" ");
        int array[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            array[i] = Integer.parseInt(strArr[i]);
        }
        return array;
    }

    static int strToInt(String a) {
        int b = Integer.parseInt(a);
        return b;
    }


}
