package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 19.03.2017.
 */
public class Runner {
    public static void main(String[] args)  {
        System.out.println("Задания к занятиям JD01_09, JD01_11.1");
        System.out.println("Вариант А:");
        oneRes("3.8+6.2");
        oneRes("87.4-23.1");
        oneRes("1.04*5.9");
        oneRes("12.7*5");
        oneRes("-6+12");
        oneRes("-7*3.1");
        oneRes("-4/8");
        oneRes("-9-0.9");
        System.out.println("Вариант B:");
        oneRes("{2,3,4}*2");
        oneRes("{2,3,4}/3");
        oneRes("{2,3,4}-5");
        oneRes("-4+{2,3,4}");
        oneRes("{2,3,4}+{5,6,7}");
        oneRes("{2,3,4}-{5,6,7}");
        System.out.println("Вариант C:");
        System.out.println("Матрицы ПОКА- не готовы");

        System.out.println("\nЗадания к занятию JD01_11.2");
        System.out.println("Вариант А:");
        Calc.calculate("A=3.8");
        Calc.calculate("B={-2,3.5,4}");
        Calc.calculate("cc=-3.8");
        Calc.calculate("c1={-2.0,-3.5,0.00,4,9}");
        System.out.println(Var.vars);
        System.out.println("Вариант B:");
        oneRes("printvar");
        System.out.println("Вариан т C:");
        oneRes("sortvar");

        oneRes("{2,3,4}/0");
        oneRes("{2,3,4}+{5,6}");
        oneRes("{2,3,4}/{}");
        oneRes("5/{2,3,4}");
     }

    private static void oneRes(String exp, String val) {
        System.out.printf("%s = %s\n",exp,val);
    }

    private static void oneRes(String exp) {
        oneRes(exp,Calc.calculate(exp));
    }
}
