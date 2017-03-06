package by.it.tereshko.jd01_04;

public class Runner {
    public static void main(String[] args) {
        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {1, 10, 9, 7},
                {3, 8, 9, 2},
        };
        double[] v = {20, 11, 40, 37};
//        InOut.arrayPrint(m,"M",true);
//        System.out.println();
//        InOut.arrayPrint(v,"V",4);
//        System.out.println();

        double[] x = Util.findRoots(m, v, true);
        InOut.arrayPrint(x, "X", 4);
    }
}
