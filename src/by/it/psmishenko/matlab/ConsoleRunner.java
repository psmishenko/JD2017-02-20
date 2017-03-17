package by.it.psmishenko.matlab;


public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }
    public static void main(String[] args) {
        Var vec1 = new VarV("{1,2,3}");
        Var vec2 = new VarV("{5,6,7}");
        oneRes(Parser.calc("1+2"));
        oneRes(Parser.calc(vec1+"+5"));
        Var mat1 = new VarM("{{1,2},{8,3}}");
        oneRes(Parser.calc(mat1+"+5"));
        oneRes(Parser.calc("A=3"));
      //  oneRes(mat1.add(new VarF("5"))); // tak li?
      //  oneRes(mat1.sub(new VarF("2")));// tak li?
      //  oneRes(mat1.mul(new VarF("4")));
      //  oneRes(mat1.div(new VarF("2")));
       // Var vec1 = new VarV("{2,3,4}");
      //  Var vec2 = new VarV("{5,6,7}");
      //  oneRes(vec1.add(new VarF("2")));
      //  oneRes(vec1.sub(new VarF("5")));
      //  oneRes(vec1.mul(vec2));
     //   oneRes(vec1.div(vec2));
      //  oneRes(vec1.add(vec2));
      //  oneRes(vec1.sub(vec2));
     //   oneRes( new VarF("3.8").add(new VarF("26.2")));
      //  oneRes( new VarF("87.4").sub(new VarF("23.1")));
      //  oneRes( new VarF("1.04").mul(new VarF("5.9")));
      //  oneRes( new VarF("12.7").div(new VarF("5")));

    }
}
