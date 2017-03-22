package by.it.psmishenko.jd01_13;

/**
 * Created by user on 22.03.2017.
 */
public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    private static void level1() throws NumberFormatException,ArithmeticException {
        System.out.println("Начало процедуры №1");
        level2();
        String s="123";
        if (Math.random()<0.5) s="qwerty";
        System.out.println(Double.parseDouble(s));
        System.out.println("Конец процедуры №1");
    }
    private static void level2() throws ArithmeticException {
        System.out.println("Начало процедуры №2");
        level3();
        if(Math.random()<0.5) throw new ArithmeticException("WOW new exception");
        System.out.println("Конец процедуры №2");
    }
    private static void level3() {
        System.out.println("Начало процедуры №3");
        try {
            int i = 3/(int)(Math.random()*4);
        }catch (ArithmeticException e){
            System.out.println("Ошибка: "+e.getMessage());
        }
        System.out.println("Конец процедуры №3");
    }
}
