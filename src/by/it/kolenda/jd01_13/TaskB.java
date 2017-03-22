package by.it.kolenda.jd01_13;


public class TaskB {
    public static void main(String[] args) {
        try {
            level1();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    private static void level1() throws NumberFormatException,ArithmeticException{
        System.out.println("Beginning of procedure level1");
        level2();
        String s="123";
        if (Math.random()<0.5)
            s="qwerty";
        System.out.println("End of procedure level1");
    }
    private static void level2() throws ArithmeticException{
        System.out.println("Beginning of procedure level2");

        level3();
        if(Math.random()<0.5)
       throw new ArithmeticException("Exception generation");
        System.out.println("End of procedure level2");
    }
    private static void level3(){
        System.out.println("Beginning of procedure level3");
 try{

 }
 catch(ArithmeticException e){
     System.out.println("Error: "+e.getMessage());
 }
        int i=3/(int)(Math.random()*2);
        System.out.println("End of procedure level3");
    }
}
