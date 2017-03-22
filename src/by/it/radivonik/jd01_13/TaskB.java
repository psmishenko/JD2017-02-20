package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 22.03.2017.
 */
public class TaskB {
    public static void main(String[] args) {
        try {
            while (true)
                level1();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    };

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
        /*if (Math.random() < 0.5)
            throw new ArithmeticException("Генерация ошибки");*/
        level3();
        System.out.println("Окончание процедуры level2");
    }

    public static void level3() {
        System.out.println("Начало процедуры level3");
        try {
            int i = 3 / (int) (Math.random() * 4);
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
        System.out.println("Окончание процедуры level3");
    }
}

