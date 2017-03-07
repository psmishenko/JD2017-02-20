package by.it.ikavalenka.jd_01.jd_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 01.03.2017.
 */
public class Avg {
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

    static double average(Integer array[]) {
        double res = 0;
        for (int i : array) res = res + i;
        res = res / array.length;
        return res;
    }

    static boolean compareavg(Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i = 0; i <ch.length ; i++)
            for (int j =i+0; j <ch.length ; j++)
                  if (ch[i] == ch[j]) return false;
            return true;
            }




    public static void main(String[] args) throws IOException {

        Integer[] integers = klavaMass();
        System.out.println("avg = " + average(integers));
    }
}

