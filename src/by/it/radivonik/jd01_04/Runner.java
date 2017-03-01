package by.it.radivonik.jd01_04;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class Runner {
    public static void main (String[] args) {
        double[] y = {20, 11, 40, 37};
        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };

        double[] x = TaskA.findRoot(m,y,false);
        InOut.arrayPrint(x,"x",1);
    }
}
