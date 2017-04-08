package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 19.03.2017.
 */
public class Runner {
    public static void main(String[] args)  {
        oneRes("(3.8+6.2)*2");
        oneRes("(28-21)/7");
        oneRes("1.04*5.9-0.136");
        oneRes("12*5+10*((4-3)*5)");

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

        System.out.println("\nЗадания к занятию JD01_11 (переменные)");
        System.out.println("Вариант А:");
        Calc.calculate("A=3.8");
        Calc.calculate("B={-2,3.5,4}");
        Calc.calculate("cc=-3.8");
        Calc.calculate("c1={-2.0,-3.5,0.00,4,9}");
        System.out.println("Вариант B:");
        oneRes("printvar",true);
        System.out.println("Вариант C:");
        oneRes("sortvar",true);
/*
        System.out.println("\nЗадания к занятию JD01_13 (исключения)");
        oneRes("{2,3,4}/0");
        oneRes("{2,3,4}+{5,6}");
        oneRes("{2,3,4}/{}");
        oneRes("5/{2,3,4,6}");
        oneRes("X=");

        System.out.println("\nЗадания к занятию JD01_15 (потоки ввода вывода)");
        System.out.println("Смотрите файл vars.txt");
        try {
            new Var().saveToFile();
            new Var().loadFromFile();
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        oneRes("printvar");
        System.out.println("Смотрите файл log.txt");*/

        System.out.println("\nЗадания к занятию JD02_04 (сложный парсер + тесты JUnit)");
        System.out.println("Вариант А:");
        oneRes("A=2+5.3");
        oneRes("B=A*3.5");
        oneRes("B1=B+0.11*-5");
        oneRes("B2=A/2-1");
        System.out.println("Вариант B:");
        oneRes("C=B+(A*2)");
        oneRes("D=((C-0.15)-20)/(7-5)");
        oneRes("E={2,3}*(D/2)");
        oneRes("printvar",true);
        System.out.println("Вариант C:");
        System.out.println("Матрицы ПОКА- не готовы");
    }

    private static void oneRes(String exp, String val, boolean newLine) {
        System.out.printf("%s =%s%s\n",exp,(newLine?"\n":" "),val);
    }

    private static void oneRes(String exp, boolean newLine) {
        oneRes(exp,Calc.calculate(exp),newLine);
    }

    private static void oneRes(String exp) {
        oneRes(exp,Calc.calculate(exp),false);
    }
}
