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

    public static void main(String[] args) {

        // 3.8+26.2

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

        System.out.println("=== тест матриц:");

        VarM M=new VarM("{{55.2,33.33},{8,3.3}}");
        oneRes(M);

        double [] [] aaa={{5,5},{7,8}};
        VarM M2=new VarM(aaa);
        oneRes(M2);

    }

}
