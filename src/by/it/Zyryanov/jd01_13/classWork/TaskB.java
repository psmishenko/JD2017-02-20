package by.it.Zyryanov.jd01_13.classWork;


public class TaskB {
    public static void main(String[] args) {


        try {
            level1();
        } catch (Exception e){
            System.out.println(e);
        }
    }




    private static void level1() throws InterruptedException {
        System.out.println("Начало процедуры level1");
        level2();
        System.out.println("Конец процедуры level1");
    }

    private static void level2() throws InterruptedException {
        System.out.println("Начало процедуры level2");
        level3();
        System.out.println("Конец процедуры level2");
    }

    private static void level3() throws InterruptedException {
        System.out.println("Начало процедуры level3");
        Thread.sleep(100);
        int i = 3/(int)(Math.random()*4);
        System.out.println("Конец процедуры level3");
    }


}
