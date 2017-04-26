package by.it.Zyryanov.jd01_13.homework;


public class TaskB {
    public static void main(String[] args) {


        String[] st = new String[2];

        try {
            System.out.println(st[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка! Нет элемента в массиве с таким индексом");
        }

        try {
            level1();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private static void level1() throws InterruptedException {
        System.out.println("Начало процедуры level1");
        level2();
        String s = "123";
        if (Math.random() < 0.5) s="qwerty";
        System.out.println("Конец процедуры level1");
    }

    private static void level2() throws InterruptedException, ArithmeticException {
        System.out.println("Начало процедуры level2");
        double root = Math.sqrt(-1D + (int) (Math.random() * 3));
        level3();
        if (Math.random() < -0.5) throw new ArithmeticException("Генерация исключения");
        System.out.println("Конец процедуры level2");
    }

    private static void level3() {
        System.out.println("Начало процедуры level3");
        try {
            Thread.sleep(100);
            int i = 3/(int)(Math.random()*4);
        } catch (InterruptedException e) {
            System.out.println("Ошибка " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка " + e.getMessage());
        }
        System.out.println("Конец процедуры level3");
    }


}
