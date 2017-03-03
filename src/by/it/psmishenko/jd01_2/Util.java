package by.it.psmishenko.jd01_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    static String getOneLine() throws IOException {
        BufferedReader stBufIn = new BufferedReader(new InputStreamReader(System.in));
        String line = stBufIn.readLine();
       // stBufIn.close();
        return line;
    }
    static int[] lineToIntArray(String line) {
        String[] strArray = line.split(" "); // делим строку на отдельные элементы
        int[] array = new int[strArray.length]; // создаём массив для буд. значений
        for (int i = 0; i < strArray.length ; i++){array[i] = Integer.parseInt(strArray[i]);}
        return array;
    }

    }

