package by.it.smirnov.jd01_04;

import java.net.SocketPermission;

/**
 * Created by aleksey.smirnov on 27.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        double[][] m={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2}
        };
        InOut.arrayPrint2D(m,"m");
        double[] y={20,11,40,37};
        InOut.printDoubleArray(y,"y", 1);

        // Task A
        //InOut.printDoubleArray(Util.findRoot(m,y,false),"res", 1);

        // Task B
        //System.out.println("Определитель матрицы равен " +
        //        Util.findDeterminant(m,true));

        // Task C
        double[][] iA = Util.inverseMatrix(m, false);
        System.out.println("Обратнная матрица:");
        InOut.arrayPrint2D(iA, "obr");
        System.out.println("Результат умножения матрицы на обратную матрицу:");
        InOut.arrayPrint2D(Util.arrayMulVector(m, iA), "res");

    }
}
