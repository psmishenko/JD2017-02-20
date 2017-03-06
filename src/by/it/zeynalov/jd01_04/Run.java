package by.it.zeynalov.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Run {

    public static void main(String[] args) {

        double[][] m = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2},
        };

        double[] y = {20, 11, 40, 37};
        //произведение матрицы и вектора
        double[] x = Util.findRoots(m, y, false);
        InOut.arrayPrint1D(x, "x", 1);


        System.out.println("------------------------------------");

        //вывод произведения матрицы на корень вектора
        double[] y2 = Util.arrayVector(m, x);
        InOut.arrayPrint1D(y2, "Y2", 4);

        //вывод опредилителя матрицы
        System.out.println(Util.findDeterminant(m));

    }
}
