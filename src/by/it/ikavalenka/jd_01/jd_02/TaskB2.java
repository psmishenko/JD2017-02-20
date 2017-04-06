package by.it.ikavalenka.jd_01.jd_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 04.04.2017.
 */
public class TaskB2 {
    public static void main(String[] args) throws IOException {

        System.out.print("Entered value k:");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String input = bufferedReader.readLine();

        bufferedReader.close();

        int m = Integer.valueOf(input);

        if (isSquare(m)) {
            System.out.println("Value 'k' is valid");
            printM(m);
        } else {
            System.out.println("Error 'k' value");
        }
    }

    public static boolean isSquare(int i) {
        return isValid(Math.sqrt(i));
    }

    public static boolean isValid(double d) {
        return d% 1== 0;
    }

    public static void printM(int k) {
        int kvd = (int)Math.sqrt(k);
        int num = 1;

        for(int i = 0; i < kvd; i++) {
            for (int j = 0; j < kvd; j++) {
                System.out.printf("%8d",num++);
            }

            System.out.println("");
        }
    }
}
