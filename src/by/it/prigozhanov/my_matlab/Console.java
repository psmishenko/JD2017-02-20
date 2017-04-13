package by.it.prigozhanov.my_matlab;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public class Console {
    private static void printRes(Var var) {
        if (var!=null) {
            System.out.println(var);
        }

    }

    public static void main(String[] args) {
        printRes(Calculator.calculate("{1,2,3,4,5}+2"));
        printRes(Calculator.calculate("{1,2,3,4,5}-2"));
        printRes(Calculator.calculate("{1,2,3,4,5}/2"));
        printRes(Calculator.calculate("{1,2,3,4,5}*2"));
    }
}
