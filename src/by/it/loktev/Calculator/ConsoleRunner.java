package by.it.loktev.Calculator;

public class ConsoleRunner {

    private static void oneRes(Var v){
        if (v!=null)
            System.out.println(v);
    }

    public static void main(String[] args) {

        // 3.8+26.2

        Var res=new VarF("3.8").add(new VarF("26.2"));
        oneRes(res);

        // 87.4-23.1 1.04*5.9 12.7*5 -6+12 -7*3.1 -4/8 -9-0.9


    }

}
