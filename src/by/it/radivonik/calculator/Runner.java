package by.it.radivonik.calculator;

import by.it.radivonik.calculator.variable.Var;

/**
 * Created by Radivonik on 19.03.2017.
 */
public class Runner {
    public static void main(String[] args)  {
/*
        System.out.println("Задания к занятиям JD01_09, JD01_11.1");
        System.out.println("Вариант А:");
        Calc.calculatePrint("3.8+6.2");
        Calc.calculatePrint("87.4-23.1");
        Calc.calculatePrint("1.04*5.9");
        Calc.calculatePrint("12.7*5");
        Calc.calculatePrint("-6+12");
        Calc.calculatePrint("-7*3.1");
        Calc.calculatePrint("-4/8");
        Calc.calculatePrint("-9-0.9");
        System.out.println("Вариант B:");
        Calc.calculatePrint("{2,3,4}*2");
        Calc.calculatePrint("{2,3,4}/3");
        Calc.calculatePrint("{2,3,4}-5");
        Calc.calculatePrint("-4+{2,3,4}");
        Calc.calculatePrint("{2,3,4}+{5,6,7}");
        Calc.calculatePrint("{2,3,4}-{5,6,7}");
        System.out.println("Вариант C:");
        Calc.calculatePrint("{{2,3,4},{5,6,8}}*2");

        System.out.println("\nЗадания к занятию JD01_11 (переменные)");
        System.out.println("Вариант А:");
        Calc.calculate("A=3.8");
        Calc.calculate("B={-2,3.5,4}");
        Calc.calculate("cc=-3.8");
        Calc.calculate("c1={-2.0,-3.5,0.00,4,9}");
        System.out.println("Вариант B:");
        Calc.calculatePrint("printvar",true);
        System.out.println("Вариант C:");
        Calc.calculatePrint("sortvar",true);

        System.out.println("\nЗадания к занятию JD01_13 (исключения)");
        Calc.calculatePrint("{2,3,4}/0");
        Calc.calculatePrint("{2,3,4}+{5,6}");
        Calc.calculatePrint("{2,3,4}/{}");
        Calc.calculatePrint("5/{2,3,4,6}");
        Calc.calculatePrint("X=");

        System.out.println("\nЗадания к занятию JD01_15 (потоки ввода вывода)");
        System.out.println("Смотрите файл vars.txt");
        Var.saveToFile();
        Calc.calculatePrint("printvar");
        System.out.println("Смотрите файл log.txt");
*/
        System.out.println("\nЗадания к занятию JD02_04 (сложный парсер + тесты JUnit)");
        System.out.println("Вариант А:");
        Calc.calculatePrint("A=2+5.3");
        Calc.calculatePrint("B=A*3.5");
        Calc.calculatePrint("B1=B+0.11*-5");
        Calc.calculatePrint("B2=A/2-1");
        System.out.println("Вариант B:");
        Calc.calculatePrint("C=B+(A*2)");
        Calc.calculatePrint("D=((C-0.15)-20)/(7-5)");
        Calc.calculatePrint("E={2,3}*(D/2)");
        System.out.println("Вариант C:");
        Calc.calculatePrint("M={{1,2,3,4},{-1.1,-2.2,-3.3,-3.4}}*(8/(3-1))");
//        Calc.calculatePrint("printvar",true);

        Var.saveToFile();
    }

 }
