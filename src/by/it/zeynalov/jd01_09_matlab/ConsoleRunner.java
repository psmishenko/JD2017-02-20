package by.it.zeynalov.jd01_09_matlab;

public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        oneRes(new VarF("3.8").add(new VarF("26.2")));
        oneRes(new VarF("3.8").add(new VarV()));

        oneRes(new VarF("87.4").sub(new VarF("23.1")));
        oneRes(new VarF("1.04").mul(new VarF("5.9")));
        oneRes(new VarF("12.7").div(new VarF("5")));
    }
}
