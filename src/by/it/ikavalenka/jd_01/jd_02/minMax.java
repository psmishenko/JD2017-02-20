package by.it.ikavalenka.jd_01.jd_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 28.02.2017.
 */
public class minMax {
    static Integer[] klavaMass() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] mas = line.split(" ");
        Integer[] integers = new Integer[mas.length];

        for (int j = 0; j < mas.length; j++) {

            integers[j] = Integer.parseInt(mas[j]);
        }
        return integers;
    }

    static int getMax(Integer array[]) {
        int res = array[0];
        for (int item : array) {
            if (item > res) {
                res = item;
            }
        }
        return res;
    }

    static int getMin(Integer array[]) {
        int res = array[0];
        for (int item : array) {
            if (item < res) {
                res = item;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        Integer[] integers = klavaMass();
        System.out.println("min = " + getMin(integers));
        System.out.println("max = " + getMax(integers));

    }
}