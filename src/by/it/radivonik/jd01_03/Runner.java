package by.it.radivonik.jd01_03;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by user on 24.02.2017.
 */
public class Runner {
    public static void main (String[] args) {
        // String line = InOut.consoleReadLine();
        String line = "12.5 1.25 3.8 4.69 7.48 3.99 5.98 5.99";
        System.out.println(line);
        double[] a = InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a,"A",3);
        System.out.println();

        Util.sort(a);
        System.out.println("Sort");
        InOut.printDoubleArray(a,"A",3);

//        Arrays.sort(a);
//        System.out.println("Sort");
//        InOut.printDoubleArray(a,"A",3);
    }
}
