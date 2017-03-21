package by.it.zeynalov.jd01_03;


import static by.it.zeynalov.jd01_03.InOut.arrayPrint2D;
import static by.it.zeynalov.jd01_03.InOut.input1DArray;
import static by.it.zeynalov.jd01_03.InOut.input2DArray;

public class Run {

    public static void main(String[] args) {

        double[] mass = {45, 13, 3, 5, 77, 12, 7, 54, 22, 156, 98};

        Util.bubbleSort(mass);
        InOut.printInfo();
        System.out.println(Util.maxArray(mass));
        System.out.println(Util.minArray(mass));
        InOut.printInfo();

        double[] massVektor = {3, 5, 9};
        double[][] massV = {{3, 3, 3}, {3, 3, 3}, {3, 3, 3}};

        InOut.arrayPrint1D(Util.arrayVector(massV, massVektor));
        InOut.printInfo();
        arrayPrint2D(Util.arrayMatrix(massV, massV));
        InOut.printInfo();

        input1DArray();
        arrayPrint2D(input2DArray());
    }




}

