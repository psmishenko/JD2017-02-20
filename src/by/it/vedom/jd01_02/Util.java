package by.it.vedom.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by Владислав on 25.02.2017.
 */
public class Util {

    static String getOneLine () throws IOException {
        BufferedReader stin = new BufferedReader(new InputStreamReader(System.in));
        String line = stin.readLine();
        stin.close();
        return line;
    }

    static int[] transformLineToIntArray (String line) {
        String strArray[] = line.split(" ");
        int array[] = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }
        return array;
    }

}
