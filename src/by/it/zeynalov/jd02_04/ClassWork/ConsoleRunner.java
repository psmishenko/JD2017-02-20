package by.it.zeynalov.jd02_04.ClassWork;

public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }

    public static void main(String[] args) {
        MapVars.loadMapFromFile();
//        System.out.println("\nТекущая карта переменных:\n"+ Var.vars);
        Parser parser=new Parser(Parser.Debug.ON);

        oneRes(parser.calc("A=2+5.3"));
        oneRes(parser.calc("B=A*3.5"));
        oneRes(parser.calc("B1=B-0.55"));
        oneRes(parser.calc("B2=A/2"));


        Var vec1=new VarV("{1,5}");
        Var vec2=new VarV("{1.7,2,3}");
        oneRes(parser.calc("5/0"));
        oneRes(parser.calc(vec1+"+"+vec2));

        oneRes(parser.calc("1+2"));
        oneRes(parser.calc("{1,2,3,4,5}+2"));
        oneRes(parser.calc("{1,2,3,4,5}*2"));
        oneRes(parser.calc("{1,2,3,4,5}/2"));
        oneRes(parser.calc("{1,2,3,4,5}-2"));
        oneRes(parser.calc("A=3"));
        oneRes(parser.calc("B={1,2,3,4}"));
        oneRes(parser.calc("C=5"));
        oneRes(parser.calc("D=7"));

        MapVars.saveMapToFile();
    }
}
