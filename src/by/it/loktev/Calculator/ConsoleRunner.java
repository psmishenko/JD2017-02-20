package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleRunner {

    private static void oneRes(Var v){
        if (v!=null)
            System.out.println(v);
    }

    private static Var newVar(String str){
        if ( VarF.canFromString(str) )
            return new VarF(str);
        if ( VarV.canFromString(str) )
            return new VarV(str);
        if ( VarM.canFromString(str) )
            return new VarM(str);
        return null;
    }

    /*
    public class TTT<T extends Object>
    {
        public <T> void F(){
            T vvv=new T();
        }
    }
    */

    public static void main(String[] args) {

        System.out.println("=== скаляр со скаляром:");

        oneRes(new VarF("3.8").add(new VarF("26.2")));
        oneRes(new VarF("3.8").div(new VarF("26.2")));
        oneRes(new VarF("3.8").sub(new VarF("26.2")));
        oneRes(new VarF("-3.8").mul(new VarF("26.2")));

        System.out.println("=== вектор с вектором:");

        oneRes(new VarV("{55.2,33.33,8,3.3}").add(new VarV("{1,2,3,4}")));
        oneRes(new VarV("{55.2,33.33,8,3.3}").sub(new VarV("{1,2,3,4}")));
        oneRes(new VarV("{55.2,33.33,8,3.3}").mul(new VarV("{1,2,3,4}")));

        System.out.println("=== вектор со скаляром:");

        oneRes(new VarV("{55.2,33.33,8,3.3}").add(new VarF("1")));
        oneRes(new VarV("{55.2,33.33,8,3.3}").sub(new VarF("1")));
        oneRes(new VarV("{55.2,33.33,8,3.3}").mul(new VarF("2")));
        oneRes(new VarV("{55.2,33.33,8,3.3}").div(new VarF("2")));

        System.out.println("=== скаляр с вектором (авто-коммутация):");

        oneRes(new VarF("1").add(new VarV("{55.2,33.33,8,3.3}")));
        oneRes(new VarF("2").mul(new VarV("{55.2,33.33,8,3.3}")));

        System.out.println("=== матрица с матрицей:");

        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").mul(new VarM("{{2},{3}}")));

        System.out.println("=== матрица с вектором:");

        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").mul(new VarV("{2,3}")));

        System.out.println("=== матрица со скаляром:");

        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").mul(new VarF("2")));
        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").div(new VarF("2")));
        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").add(new VarF("2")));
        oneRes(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}").sub(new VarF("2")));

        System.out.println("=== вектор с матрицей (авто-коммутация):");

        oneRes(new VarV("{2,3}").mul(new VarM("{{5.2,3.3,2.2},{1,5,2.2}}")));

        System.out.println("=== скаляр с матрицей (авто-коммутация):");

        oneRes(new VarF("2").mul(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}")));
        oneRes(new VarF("2").add(new VarM("{{5.2,3.3},{8,1.3},{1,2.2}}")));

        System.out.println("=== тест парсера:");

        oneRes(Parser.parseAndCalc(" 6+3 ",false));
        oneRes(Parser.parseAndCalc(" 6+3*4/6-1 ",false));
        oneRes(Parser.parseAndCalc(" {5,7}+3 ",false));
        oneRes(Parser.parseAndCalc(" {5,7}+{1,3} ",false));
        oneRes(Parser.parseAndCalc(" {5,7}*2 ",false));
        oneRes(Parser.parseAndCalc(" {{5.2,3.3},{8,1.3},{1,2.2}} * {{2},{3}} ",false));
        oneRes(Parser.parseAndCalc(" {{5.2,3.3},{8,1.3},{1,2.2}} * {2,3} ",false));
        oneRes(Parser.parseAndCalc(" {{5.2,3.3},{8,1.3},{1,2.2}} + 1 ",false));
        oneRes(Parser.parseAndCalc(" -9-0.9 ",false));
        oneRes(Parser.parseAndCalc(" (6+3)*2 ",false));
        oneRes(Parser.parseAndCalc(" (6+3)*(2+1) ",false));
        oneRes(Parser.parseAndCalc(" -(6+3)*4/(7-1) ",false));
        oneRes(Parser.parseAndCalc(" 2*(3+4*(1+5)) ",false));

        System.out.println("=== тест работы с переменными:");

        Parser.parseAndCalc("aaa=5+2 ",false);
        Parser.parseAndCalc("ccc=8 ",false);
        Parser.parseAndCalc("bbb=7+1*2 ",false);
        Parser.parseAndCalc("printvar",false);
        Parser.parseAndCalc("sortvar",false);
        oneRes(Parser.parseAndCalc(" aaa+1+bbb ",false));

        //Storage.store("a",new VarF("5.5"));
        //System.out.println(Storage.restore("a"));
    }

}
