package by.it.prigozhanov.jd01_04;

/**
 * Created by Vladimir on 27.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        double[][] m = {
                {16, 2, 52, 3},
                {1, 24, 11, 5},
                {2, 23, 51, 2},
                {3, 11, 2, 51}
        };
    double[] y = {20, 11, 40, 37};
        Util.findRoots(m, y, true);
        InOut.arrayPrint(Util.findRoots(m, y, false), "X", 1);
        Util.checker(m, Util.findRoots(m, y, false));
        Util.findDeterminant(m);

        double[][] inv = {
                {16, 2, 52, 3},
                {1, 24, 11, 5},
                {2, 23, 51, 2},
                {3, 11, 2, 51}
        };
        Util.inverseMarix(inv, false);
        InOut.arrayPrint(inv, "I", false);
        Util.inverseMarix(inv, false);
        InOut.arrayPrint(inv, "I", false);
    }
}
