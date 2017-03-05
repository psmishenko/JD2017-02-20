package by.it.radivonik.jd01_03;

/**
 * Created by user on 24.02.2017.
 */
public class Runner {
    public static void main (String[] args) {
        // String line = InOut.consoleReadLine();
        String line = "12.5 1.25 3.8 4.69 7.48 3.99 5.98 5.99";
        System.out.println(line);
        double[] a = InOut.readDoubleArrayFromLine(line);

        // Печать массива
        System.out.println("\nПечать массива");
        InOut.printDoubleArray(a,"A",3);

        // Сортировка массива
        System.out.println("\nСортировка массива");
        Util.sort(a);
//        Arrays.sort(a);
        System.out.println("\nСортированный массив");
        InOut.printDoubleArray(a,"A",3);

        // Поиск минимального, максимального значений
        System.out.println("\nПоиск минимального, максимального значений");
        double min = Util.getMin(a);
        System.out.printf("\nМинимальное значение = %f",min);
        double max = Util.getMax(a);
        System.out.printf("\nМаксимальное значение = %f",max);

        // Умножение матриц
        System.out.println("\nУмножение матриц");
        double[][] m1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        double[][] m2 = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 4, 5},
                {4, 5, 6},
                {5, 6, 7}
        };
        double[] v = {1, 2, 3, 4, 5};
        System.out.println("\nИсходные массивы");
        InOut.printDoubleArray(m1,"M1",5);
        InOut.printDoubleArray(m2,"M2",3);
        InOut.printDoubleArray(v,"V",5);
        System.out.println("\nУмножение матриц");
        InOut.printDoubleArray(Util.arrayMul(m1,v),"M1xV",5);
        InOut.printDoubleArray(Util.arrayMul(m1,m2),"M1xM2",3);
    }
}
