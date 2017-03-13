package by.it.loktev.Calculator;

public class ConsoleRunner {

    private static void oneRes(Var v){
        if (v!=null)
            System.out.println(v);
    }

    public static void main(String[] args) {

        // 3.8+26.2

        oneRes(new VarF("3.8").add(new VarF("26.2")));
        oneRes(new VarF("3.8").div(new VarF("26.2")));
        oneRes(new VarF("3.8").sub(new VarF("26.2")));
        oneRes(new VarF("3.8").mul(new VarF("26.2")));

        oneRes(new VarF("3.8").add(new VarV()));
        oneRes(new VarV().add(new VarF("3.8")));
        oneRes(new VarV().add(new VarV()));


    }

}
