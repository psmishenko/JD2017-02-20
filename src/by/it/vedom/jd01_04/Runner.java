package by.it.vedom.jd01_04;

public class Runner {

    public static void main(String[] args) {
        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2},
        };
        double[] y = {20, 11, 40, 37};
//        InOut.arrayPrint(m, "M", false);
//        InOut.arrayPrint(m, "M", true);
//
//
//        InOut.arrayPrint(y,"Y", 4);

        double[] x = Util.findRoots(m, y, false);
        InOut.arrayPrint(x, "X", 4);

//        Util.findRoots(m, y, true);


        System.out.println("Детерминант матрицы равен " +Util.findDeterminant(m));

        }
    }

