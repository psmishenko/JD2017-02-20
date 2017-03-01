package by.it.korzun.jd01_03;




public class Runner {
    public static void main(String[] args) {

        String line = InOut.consoleReadLine();
        double[] a = InOut.readDoubleArrayFromLine(line);
        InOut.printDoubleArray(a, "A", 4);
        Util.sort(a);
        InOut.printDoubleArray(a, "A", 4);
        System.out.println("Min = " + Util.findMin(a));
        System.out.println("Max = " + Util.findMax(a));

        double[][] matrixA = InOut.createMatrix();
        InOut.printMatrix(matrixA);
        double[][] matrixB = InOut.createMatrix();
        InOut.printMatrix(matrixB);
        System.out.println("Произведение матриц: ");
        InOut.printMatrix(Util.arrayMulVector(matrixA, matrixB));

    }

}

