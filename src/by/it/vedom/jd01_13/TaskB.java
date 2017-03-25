package by.it.vedom.jd01_13;

public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void level1() throws Exception {
        System.out.println("Начало процедуры level1");
        level2();
        String s = "123";
        if(Math.random()<0.5)
            s = "qwerty";
        System.out.println(Double.parseDouble(s)); // NumberFormatExeption
        System.out.println("Начало процедуры level1");
    }
    private static void level2() throws Exception {
        System.out.println("Начало процедуры level1");
        if(Math.random() < 0.5)
        throw new ArithmeticException("Генерация исключения");
        level3();
        System.out.println("Начало процедуры level2");
    }
    private static void level3() {
        System.out.println("Начало процедуры level3");
        try {
            int i = 3/(int) (Math.random()*2);
        }
        catch (ArithmeticException e) {
            System.out.println("Ошибка: " +e.getMessage());
        }

        System.out.println("Начало процедуры level3");
    }
}
