package by.it.prigozhanov.jd01_04;

/**
 * Created by Vladimir on 27.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
    double[] y = {20, 11, 40, 37};
        Util.findRoots(m, y, true);
        InOut.arrayPrint(Util.findRoots(m, y, false), "X", 1);
        Util.checker(m, Util.findRoots(m, y, false));
        Util.findDeterminant(m);

        double[][] inv = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        Util.inverseMarix(inv, true);
    }
}
