package by.it.loktev.jd01_13;

public class TaskB {

    public static void taskB() {
        try {
            level1();
        }
        catch ( Exception e )
        {
            System.out.println("на уровне корня словилось исключение: "+e);
        }
    }

    private static void level1()  {
        System.out.println("начало процедуры 1");
        String s="123";
        if (  Math.random()<0.5 )
            s="ddfgdfg";
        Double.parseDouble(s);
        level2();
        System.out.println("конец процедуры 1");
    }

    private static void level2()  {
        System.out.println("начало процедуры 2");
        if (  Math.random()<0.5 )
          throw new ArithmeticException("что-то на уровне 2");
        level3();
        System.out.println("конец процедуры 2");
    }

    private static void level3()  {
        System.out.println("начало процедуры 3");
        try {
            int i = 3 / ((int) (Math.random() * 2));
        }
        catch (ArithmeticException ae){
            System.out.println("словлено деление на 0");
            }
        System.out.println("конец процедуры 3");
    }

}
