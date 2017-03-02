package by.it.psmishenko.jd01_5;

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
        // var 10
        // #1
        double x1 = 2;
        System.out.println("Первый способ "+Task1.optionA(x1));
        System.out.println("Второй способ "+Task1.optionB(x1));
        // #2
        System.out.println("#2: "+Task2.calcY(0.3,-21.17));
        //#3
        double x2 = 3.567;
        Task3.printTable(x2);
        //#4
        double a = 2.408;
       System.out.println("#4:------------------\n z = "+Task4.calcZ(a));
       //#5
        Task5.calcBeta();
        //#6
        System.out.println("#6: ----------------");
        double[] arr = Task6.newMass();
        Task6.printMass(arr,"arr");
        System.out.println("Среднее арифметическое последних 10-ти элементов - "+Task6.getAvg(arr));
        Task6.printMass(Task6.getNewM(arr),"newM");
    }

}
