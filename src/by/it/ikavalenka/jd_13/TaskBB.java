package by.it.ikavalenka.jd_13;

/**
 * Created by USER on 22.03.2017.
 */
public class TaskBB {
    public static void main(String[] args) {
        try
        {
            level1();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    private static void level1()throws Exception,ArithmeticException{           //need clarification

        System.out.println("The begin of  precess lvl1");
        level2();
        String s = "123";
        if (Math.random()<0.5)
            s = "qwerty";
        System.out.println(Double.parseDouble(s));
        System.out.println("The begin of  precess lvl1");
    }
    private static void level2() throws ArithmeticException,Exception{
        System.out.println("The begin of  process lvl2");
        level3();
        if (Math.random()<0.5)
        throw new ArithmeticException("Exeption generation");

        System.out.println("The begin of  precess lvl2");
    }
    private static void level3() throws Exception{
        System.out.println("The begin of  precess lvl3");
        try
        {
            int i = 3/(int)(Math.random()*3);
        }
        catch (Exception e){
            System.out.println("MathExeption: "+e.getMessage());
        }
        Thread.sleep(100);
        int i = 3/(int)(Math.random()*3);
        System.out.println("The begin of  precess lvl3");
    }


}
