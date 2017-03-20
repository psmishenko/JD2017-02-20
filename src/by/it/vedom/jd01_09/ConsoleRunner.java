package by.it.vedom.jd01_09;

public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }
    public static void main(String[] args) {
        oneRes(new VarF("3.8").add(new VarF("26.2")));
    //    oneRes(new VarF("3.8").add(new VarV("{15, 2.6, 33, 1}")));

        oneRes(new VarF("15.5").sub(new VarF("3.3")));
        oneRes(new VarF("25.25").mul(new VarF("2.5")));
        oneRes(new VarF("25.25").div(new VarF("5")));
    }
}
