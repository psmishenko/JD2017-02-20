package by.it.ikavalenka.jd_01.jd_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 04.03.2017.
 */
public class Compare {
    public static void main(String[] args) throws IOException {
        int[] integers = eteringArray();
        int[] sortedMass = sortArray(integers);
        getUniqArray(sortedMass);

    }

    public static int[] eteringArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] mas = line.split(" ");
        int[] integers = new int[mas.length];

        for (int j = 0; j < mas.length; j++) {
            integers[j] = Integer.parseInt(mas[j]);
        }
        return integers;
    }

    public static int[] sortArray(int[] array) {
        int limit = array.length;
        for (int i = 0; i < limit - 1; i++) {
            for (int j = i; j < limit - 1; j++) {
                if (array[i] > array[j]) {
                    int buffer = array[i];
                    array[i] = array[j];
                    array[j] = buffer;
                }
            }
        }
        return array;
    }


    public static void printUniqNumber(int number) {
        char[] chars = (number + "").toCharArray();
        int limit = chars.length;
        int current = 0;
        for (int i = 0; i <= limit - 1; i++) {
            for (int j = 0; j <= limit - 1; j++) {
                if (chars[i] == chars[j]) {
                    current++;
                }
            }
        }
        if (current == limit) {
            System.out.print(number + " ");
        }
    }

    public static void getUniqArray(int[] array) {
        int currentNumber = array[0];
        printUniqNumber(currentNumber);

        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] != currentNumber) {
                printUniqNumber(array[i]);
            }
            currentNumber = array[i];
        }
    }
}