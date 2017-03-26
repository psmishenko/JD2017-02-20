package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 22.03.2017.
 * Класс, реализующий задания Варианта B
 */
public class TaskB {
    public static void level1()  {
        System.out.println("Начало процедуры level1");
        level2();
        String s = "123";
        if (Math.random() < 0.5)
            s = "adadfa";
        Double.parseDouble(s);
        System.out.println("Окончание процедуры level1");
    }

    public static void level2()  {
        System.out.println("Начало процедуры level2");
        int x = (int) (Math.random() * 5 - 2);
        if (x < 0)
            throw new ArithmeticException("Нельзя извлечь корень из отрицательного числа " + x);
        double y = Math.sqrt(x);
        level3();
        System.out.println("Окончание процедуры level2");
    }

    public static void level3() {
        System.out.println("Начало процедуры level3");
        try {
            int i = 3 / (int) (Math.random() * 5);
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
        System.out.println("Окончание процедуры level3");
    }
}

