package by.it.prigozhanov.jd01_05.math;

import static java.lang.Math.*;

/**
 * Created by v-omf on 3/1/2017.
 */
public class Task6 {
    static void calculate() {
        double[] arr = new double[40];
        double b = -2;
        double res = 1;
        int secondArrCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            int counter = 2;
            arr[i] = pow(E, abs(2 * b + 1));
            b += 0.1;
            System.out.printf("i=[%2d] = %5.3f\n", i, arr[i]);
            if (arr[i] < 3 && i % counter != 0) {

                secondArrCounter++;
                counter+=2;
                res*=arr[i];

            }
        }

        System.out.println("Произведение = " + res);

        double[] secondarr = new double[secondArrCounter];
        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            int counter = 2;
            b += 0.1;
            if (arr[i] < 3 && i % counter != 0) {
                secondarr[a] = arr[i];
                System.out.printf("firstarrindex[%-2d] newarr[%-1d]= %3.3f\n",i, a, secondarr[a]);
                a++;
                counter += 2;
            }
        }

        for (int i = 0; i < 10; i++) {
            int c = 0;
            c++;
            System.out.println(c);
        }
    }
}
