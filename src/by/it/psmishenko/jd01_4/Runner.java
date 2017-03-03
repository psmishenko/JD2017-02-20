package by.it.psmishenko.jd01_4;

import java.io.IOException;

/**
 *Класс запуска приложения
 */
public class Runner {
    /**
     * Метод main запуска приложения
     * @param args -  аргументы запуска приложения
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        double[][] a =  {
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2}};
        double [] b = {20,11,40,37};
        double[][] e = {
                {1,0,0,0},
                {0,1,0,0},
                {0,0,1,0},
                {0,0,0,1}
                                };
        InOut.printArray(a,"a");
        InOut.printArray(b,"b",3);
        double[] x = Util.findRoot(a,b);
        System.out.println("Корни СЛАУ");
        InOut.printArray(x,"x",3);
        System.out.println("Проверка (умножаем матрицу a на x). Результат должен быть равен вектору b");
        InOut.printArray(Util.arrayMulVector(a,x),"a*x",3);
        System.out.println("Определитель матрицы a: "+Util.findDeterminant(a));
        System.out.println("Обратная матрица a");
        double[][] aInv = Util.inverseMatrix(a,e);
        InOut.printArray(aInv,"aInv");
        System.out.println("Проверка метода (умножаем матрицу на её обратную матрицу). В результате должны получить ед. матрицу");
        InOut.printArray(Util.arrayMulArray(a,aInv),"a*aInv");
    }
}
