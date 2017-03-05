package by.it.prigozhanov.jd01_03;

/**
 * Created by Vladimir on 24.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        //  String line = InOut.consoleReadLine();
        String line = "9 8 7 6 5 4 0 3 2 1";
        double[] a = InOut.readDoubleArrayFromString(line);
        InOut.printDoubleArray(a, "A", 6);
        System.out.println();
        Util.sort(a);
        InOut.printDoubleArray(a, "A", 6);

        Util.getMaxValue(a);
        Util.getMinValue(a);

        double[][] matrix = {
                {1, 2, 3, 5},
                {4, 5, 6, 6}
        };

        double vector[][] = {
                {1},
                {2},
                {3},
                {4}
        };

        double[][] secondmatrix = {
                {9, 8},
                {6, 5},
                {3, 2},
                {5, 6}
        };
        InOut.printArray2D(matrix, "V");
        Util.matrixMultipliedByVector(matrix, vector);
        Util.matrixMultipliedByMatrix(matrix, secondmatrix);
    }

}