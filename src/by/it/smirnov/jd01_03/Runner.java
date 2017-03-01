package by.it.smirnov.jd01_03;

/**
 * Created by aleksey.smirnov on 24.02.2017.
 */
public class Runner {
    /**
     * Функция тестирования пакетов InOut и Util
     */
    public static void main(String[] args) {
        //String line = InOut.consoleReadLine();
        String line = "10 13 189 774 15 58 9";

        System.out.println(line);
        System.out.println();
        double[] a = InOut.readDoubleArrayFromLine(line," ");
        InOut.printDoubleArray(a, "v", 3);
        System.out.println("Max Value: "+ Util.maxDoubleArray(a));
        System.out.println("Min Value: "+Util.minDoubleArray(a));
        //Util.sortDefault(a);
        //Util.sortSelectMin(a);
        Util.sortBubble(a);
        System.out.println();
        InOut.printDoubleArray(a, "v", 3);
        double[][] s = {
                {12, 45, 24.7, 7},
                {10, 45.1, 15, 56},
                {5, 12, 7, 12.9}
        };
        //InOut.arrayPrint2D(s);
        System.out.println();
        System.out.println("Матрица:");
        InOut.arrayPrint2D(s, "s");
        double[][] d = {
                {11},
                {49},
                {78},
                {7}
        };
        System.out.println("Вектор:");
        InOut.arrayPrint2D(d, "d");
        System.out.println("Перемножение матрицы s и вектора d");
        InOut.arrayPrint2D(Util.arrayMulVector(s,d), "j");
        double[][] g = {
                {11,1},
                {49,3},
                {78,5},
                {7,4}
        };
        System.out.println("Матрица 2:");
        InOut.arrayPrint2D(g, "g");
        System.out.println("Перемножение матриц s и g");
        InOut.arrayPrint2D(Util.arrayMulVector(s,g), "v");

    }
}
