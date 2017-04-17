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
        System.out.println(new VarMatrix("{{1,2,3,4},{5,6,7,8},{9,10,11,12}}"));

    }
}
