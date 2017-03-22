package by.it.prigozhanov.jd01_13;

import java.util.regex.Matcher;


/**
 * Created by v-omf on 3/22/2017!
 */
public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void level1() throws NumberFormatException, ArithmeticException {
        System.out.println("Начало процедуры level1");
        level2();
        String s = "123";
        if (Math.random() < 0.5) s="qwerty";
        System.out.println("Конец процедуры level1");
    }

    private static void level2() throws ArithmeticException {
        System.out.println("Начало процедуры level2");
        double root = Math.sqrt(-1D + (int) (Math.random() * 3));
        level3();
        if (Math.random() < -0.5) throw new ArithmeticException("Генерация исключения");
        System.out.println("Конец процедуры level2");
    }

    private static void level3() throws ArithmeticException {
        System.out.println("Начало процедуры level3");
        try {
            int i = 3 /(int)(Math.random() * 2);
        } catch (ArithmeticException e) {
            System.out.println("Ощибка деления на 0" + e.getMessage());
        }
        System.out.println("Конец процедуры level3");

    }

}
