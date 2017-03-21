package by.it.tereshko.jd01_03;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
//        String line = InOut.consoleReadLine();
//        System.out.println(line);
        String line = "12 34 567 678 789 45 21";
        double[] a = InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a,"A",4);
        Arrays.sort(a);
//        Util.sort(a);
        InOut.printDoubleArray(a,"A",4);
    }
}
