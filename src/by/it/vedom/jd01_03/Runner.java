package by.it.vedom.jd01_03;

/**
 * Created by Владислав on 24.02.2017.
 */
public class Runner {
    public static void main(String[] args) {

        //String line = inout.consoleReadLine();
        String line = "9 5 2 3 4 8 1 6 7";
        System.out.println("Исходный массив");
        System.out.println(line);

        double[][] m1 = {
                {1, 5, 6, 1},
                {1, 3, 2, 1},
                {2, 0, 9, 7},
                {3, 8, 9, 2},
        };

        double[][] m2 = {
                {1, 5, 6, 1},
                {1, 3, 2, 1},
                {2, 0, 9, 7},
                {3, 8, 9, 2},
        };

        double[] vectorForMatrix = {1, 2, 3, 4};

        //Заполнение матрицы с клавиатуры
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите количество строк первой матрицы: ");
//        int row = scanner.nextInt();
//        System.out.print("Введите количество столбцов первой матрицы: ");
//        int col = scanner.nextInt();
//        System.out.println("Заполните вашу матрицу размером " +row+ "x" +col);
//        double[][] matrix = InOut.initDoubleMatrix(row, col, "Matrix A");
//        InOut.onlyPrintDoubleMatrix(matrix, "A");
//        System.out.println();

//        System.out.print("Введите размерность вектора: ");
//        int sizeOfVector = scanner.nextInt();
//        System.out.println("Заполните ваш вектор размером " +sizeOfVector);
//        double[] vector = InOut.initDoubleArray(sizeOfVector, "Vector");
//        System.out.println("Ваш вектор");
//        InOut.printDoubleArray(vector, "A", 4);
//        System.out.println("Результирующая матрица");
//        double[] resultMatrix = Util.matrixMulVector(matrix, vector);
//        InOut.printDoubleArray(resultMatrix, "m", 3);
//        System.out.println();

        InOut.onlyPrintDoubleMatrix(m1, "A");
        System.out.println();
        InOut.onlyPrintDoubleMatrix(m2, "B");
        System.out.println();
        double[][] matrMULmatr = Util.matrixMulmatrix(m2, m1);
        InOut.onlyPrintDoubleMatrix(matrMULmatr, "C");

        double[] qwerty = Util.matrixMulVector(m1, vectorForMatrix);
        InOut.printDoubleArray(qwerty, "V", 1);
        System.out.println();

        double[] a = InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a, "A", 4);
        System.out.println();

        Util.bubbleSort(a);
        //Arrays.sort(a);
        System.out.println();

        System.out.println("Отсортированный массив");
        InOut.printDoubleArray(a, "A", 4);
        System.out.println();

        double min = Util.getMin(a);
        System.out.println("Минимальный элемент массива равен " +min);
        double max = Util.getMax(a);
        System.out.println("Максимальынй элемент массива равен " +max);



    }
}
