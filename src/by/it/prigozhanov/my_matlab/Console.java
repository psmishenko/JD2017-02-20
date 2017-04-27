package by.it.prigozhanov.my_matlab;


/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public class Console {
    private static void printRes(Var var) {
        if (var != null) {
            System.out.println(var);
        }

    }

    public static void main(String[] args) throws MatlabException {
       printRes(Calculator.calculate("{{2,4,0},{-2,1,3},{-1,0,1}}*{1,2,-1}"));
        //{{2,4,0},{-2,1,3},{-1,0,1}}
        //{1,2,-1}
    }
}
