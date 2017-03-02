package by.it.sorokoee.jd01_05;

import by.it.sorokoee.jd01_05.math.*;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
         //Задача1

        System.out.println(Task1.optA(1.21,0.371));
        System.out.println(Task1.optB(1.21,0.371));
        System.out.println();

        //Задача2

        System.out.println("z="+ Task2.optC(3.24,5.8));
        Task2.optD();
        System.out.println();

        //Задача3

        Task3.printTable(12.1);
        System.out.println();

        //Задача4

        System.out.println(Task4.calculate());
        System.out.println();

        //Задача5

        Task5.functionCalcul(4.73);
        System.out.println();

        //Задача6

        Task6.printMass(Task6.getMass(34),"Mass");
        Task6.getPrintSumma(Task6.getMass(34),"Mass");
        Task6.printMass(Task6.getNewMass(Task6.getMass(34)),"M");
        System.out.println();

        //Задача7

        Task7.printMassiv(Task7.getMassiv(34),"T");
        Task7.printMassiv(Task7.sortNewMass(Task7.getMassiv(34)),"K");

    }
}
