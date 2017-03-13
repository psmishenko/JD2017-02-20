package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class ConsoleRunner {
    public static void main(String[] args) {
        oneRes("3.8 + 26.2",new VarFloat("3.8").add(new VarFloat("26.2")));
        oneRes("87.4 - 23.1",new VarFloat("87.4").sub(new VarFloat("23.1")));
        oneRes("1.04 * 5.9",new VarFloat("1.04").mul(new VarFloat("5.9")));
        oneRes("12.7 * 5",new VarFloat("12.7").mul(new VarFloat("5")));
        oneRes("-6 + 12",new VarFloat("-6").add(new VarFloat("12")));
        oneRes("-7 * 3.1",new VarFloat("-7").mul(new VarFloat("3.1")));
        oneRes("-4 / 8",new VarFloat("-4").div(new VarFloat("8")));
        oneRes("-9 - 0.9",new VarFloat("-9").sub(new VarFloat("0.9")));

        oneRes("3.8 + {26.2}",new VarFloat("3.8").add(new VarVector()));
    }

    private static void oneRes(String exp, Var var) {
        System.out.printf("%s = ",exp);
        if (var != null) {
            System.out.println(var);
        }
        System.out.flush();
    }
}
