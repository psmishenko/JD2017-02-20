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
        printRes(new VarValue("1").plus(new VarValue("2")));
        printRes(new VarValue("1").minus(new VarValue("2")));
        printRes(new VarValue("1").div(new VarValue("2")));
        printRes(new VarValue("1").mul(new VarValue("2")));
        double[] arr = new double[] {1, 2, 3, 4, 5, 6, 7};
        VarVector a = new VarVector(arr);
        System.out.println(a);
    }
}
