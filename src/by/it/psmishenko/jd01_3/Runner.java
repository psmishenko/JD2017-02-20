package by.it.psmishenko.jd01_3;


import java.io.IOException;

/**
 * Класс запуска приложения
 */
public class Runner {
    /**
     * Метод main запуска приложения
     * @param args -  аргументы запуска приложения
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        boolean zxc = true; // переменная для цикла do-while
        do {
            System.out.println("Введите тип массива (1 для одномерного, 2 для двумерного)");
            String typeOfMass = InOut.consoleReadLine();
            switch (typeOfMass) {
                case "1": // Для одномерного массива
                    System.out.println("Введите массив:");
                    String str = InOut.consoleReadLine();
                    System.out.println("Введите имя массива");
                    String nameOfMass = InOut.consoleReadLine();
                    double[] mas = InOut.stringLineToDoubleArray(str);
                    InOut.printArray(mas, nameOfMass, 4);
                    double maxOfMass = Util.maxDoubleArray(mas);
                    double minOfMass = Util.minDoubleArray(mas);
                    System.out.printf("Минимум массива %-3s = %-4.4f , Максимум массива %-3s = %-4.4f \n ",
                            nameOfMass, minOfMass,nameOfMass,maxOfMass );
                    System.out.println("Сортировка пузырьком (только up) ");
                    InOut.printArray(Util.sortSimpleBubbleDoubleArray(mas),nameOfMass,4);
                   System.out.println("Введите тип сортировки (up - для восходящей, down - для нисходящей)");
                    String typeOfSort = InOut.consoleReadLine();
                    System.out.println("Сортировка пузырьком c указанным направлением ("+typeOfSort+")");
                    switch (typeOfSort) {
                        case "up":
                            InOut.printArray(Util.sortBubbleDoubleArray(mas,true),nameOfMass,4);
                            break;
                        case "down":  InOut.printArray(Util.sortBubbleDoubleArray(mas,false),nameOfMass,4); break;
                        default: System.out.println("Неверный ввод"); break;}
                    break;
                case "2": // Для двумерного массива
                    System.out.println("Введите кол-во строк массива:");
                    int n = Integer.parseInt(InOut.consoleReadLine());
                    System.out.println("Введите двумерный массив:");
                    String[] strMass2D = InOut.consoleReadMass(n);
                    System.out.println("Введите имя массива");
                    String nameOfMass2D = InOut.consoleReadLine();
                    double[][] mas2D = InOut.stringMasstoDoubleArray(strMass2D);
                    InOut.printArray(mas2D,nameOfMass2D);
                    double [] masX1 = {1,2,-1};
                   System.out.println("Результат умножения матрицу на вектор ");
                    InOut.printArray(Util.arrayMulVector(mas2D,masX1),"res",4);
                    double [][] masX2 = {
                            {8,1,3},
                            {1,3,2},
                            {4,3,9}
                    };
                    System.out.println("Результат умножения матрицу на матрицу ");
                    InOut.printArray(Util.arrayMulArray(mas2D,masX2),"a*m");
                   break;
                default:
                    zxc = false;
            }
        }
            while (zxc) ;
    }
     /*
                        для проверки : 2 4 0
                                      -2 1 3
                                      -1 0 1
                        результат умножения на вектор: 10 -3 -2
                        результат умножения на матрицу: 20 14 14
                                                        -3 10 23
                                                        -4 2  6
                     */
}