package by.it.akhmelev.jd01_13_classwork_matlab;

public class ConsoleRunner {

    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        Var vec1=new VarV("{1,5}");
        Var vec2=new VarV("{1.7,2,3}");

        oneRes(Parser.calc("5/0"));
       // oneRes(Parser.calc(vec1+"+"+vec2));

//        oneRes(Parser.calc("1+2"));
//        oneRes(Parser.calc("{1,2,3,4,5}+2"));
//        oneRes(Parser.calc("{1,2,3,4,5}*2"));
//        oneRes(Parser.calc("{1,2,3,4,5}/2"));
//        oneRes(Parser.calc("{1,2,3,4,5}-2"));
//        oneRes(Parser.calc("A=3"));
//        oneRes(Parser.calc("B={1,2,3,4}"));
//        oneRes(Parser.calc("C=5"));
//        oneRes(Parser.calc("A=7"));

//        System.out.println(Var.vars);

//        oneRes(vec1.add(vec2));
//        oneRes(vec1.sub(vec2));
//        oneRes(vec1.mul(vec2));
//        oneRes(vec1.div(vec2));

//        oneRes(new VarF("3.8").add(new VarF("26.2")));
//        oneRes(new VarF("3.8").add(new VarV()));
//
//        oneRes(new VarF("87.4").sub(new VarF("23.1")));
//        oneRes(new VarF("1.04").mul(new VarF("5.9")));
//        oneRes(new VarF("12.7").div(new VarF("5")));
    }
}
