package by.it.psmishenko.matlab;


public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }
    public static void main(String[] args) {
        // тестовые строки из jd01_11
      String levelA = "2.3+3";
      String levelB = "{1,2,3}/5";
      String levelC = "{{1,2},{4,5}}*{1,2}";
      System.out.print("A: "+levelA+" = "); oneRes(Parser.calc(levelA));
        System.out.print("B: "+levelB+" = "); oneRes(Parser.calc(levelB));
        System.out.print("C: "+levelC+" = ");  oneRes(Parser.calc(levelC));

       // oneRes(Parser.calc("Ala=3"));
        //oneRes(Parser.calc("Bor={1,2,3,4}"));
       // oneRes(Parser.calc("Cle=5"));
       // oneRes(Parser.calc("Ona=7"));
       // System.out.println(Var.vars);



        // тестовые строки из jd01_09 для матриц
       // oneRes(Parser.calc("{{1,2},{8,3}}+5"));
       // oneRes(Parser.calc("{{1,2},{8,3}}-5"));
       // oneRes(Parser.calc("{{1,2},{8,3}}*5"));
       // oneRes(Parser.calc("{{1,2},{8,3}}/5"));
       // oneRes(Parser.calc("{{1,2},{8,3}}*{1,2}"));
       // oneRes(Parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}"));
       // oneRes(Parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}"));
       // oneRes(Parser.calc("{{1,2},{8,3}}-{{1,2},{8,3}}"));

    }
}
