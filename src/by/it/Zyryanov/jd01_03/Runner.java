package by.it.Zyryanov.jd01_03;





public class Runner {
    public static void main(String[] args) {

        double[] v = {5, 1, 4, 2};


        double[][] m = {
                {12, 13, 12, 11},
                {11, 14, 15, 16},
                {17, 19, 20, 21},
                {22, 33, 55, 44}
        };



        System.out.println("Задание 1");
        System.out.println();
        InOut.printArray(v," l ", 5);
        System.out.println();

        System.out.println("Задание 2");
        System.out.println();
        Util.arraySort(v);
        System.out.println();


        System.out.println("Задание 3");
        System.out.println();
        Util.maxFinder(v);
        System.out.println();
        Util.minFinder(v);


        double[][] y = {
                {12, 13, 12},
                {11, 14, 15}
        };

        double[][] x = {
                {14, 12},
                {15, 11},
                {16, 10},
                {21, 33}
        };

        System.out.println("Задание 4.1 матрица умноженная на вектор");
        System.out.println();
        InOut.printArray2D(m, "m", 4);
        InOut.printArray(v, "v", 1);
        Util.matrixMulByVector(m, v);
        System.out.println();
        System.out.println("Задание 4.2 матрица умноженная на матрицу");
        Util.matrixMulByMatrix(x,y);


    }
}
