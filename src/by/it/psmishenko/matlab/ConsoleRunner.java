package by.it.psmishenko.matlab;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }
    static String getOneLine() throws IOException {
        BufferedReader stBufIn = new BufferedReader(new InputStreamReader(System.in));
        String line = stBufIn.readLine();
        // stBufIn.close();
        return line;
    }

    public static void main(String[] args) throws IOException {
        boolean zxc = true;
        // тестовые строки из jd01_11
      String levelA = "2.3+3";
      String levelB = "{1,2,3}/5";
      String levelC = "{{1,2},{4,5}}*{1,2}";
      System.out.print("A: "+levelA+" = "); oneRes(Parser.calc(levelA));
        System.out.print("B: "+levelB+" = "); oneRes(Parser.calc(levelB));
        System.out.print("C: "+levelC+" = ");  oneRes(Parser.calc(levelC));
        // тестовые строки из jd01_09 для матриц
        // oneRes(Parser.calc("{{1,2},{8,3}}+5"));
        // oneRes(Parser.calc("{{1,2},{8,3}}-5"));
        // oneRes(Parser.calc("{{1,2},{8,3}}*5"));
        // oneRes(Parser.calc("{{1,2},{8,3}}/5"));
        // oneRes(Parser.calc("{{1,2},{8,3}}*{1,2}"));
        // oneRes(Parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}"));
        // oneRes(Parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}"));
        // oneRes(Parser.calc("{{1,2},{8,3}}-{{1,2},{8,3}}"));
        Parser.calc("Alla=3");
        Parser.calc("Boris={1,2,3,4}");
        Parser.calc("Cleopatra=5");
        Parser.calc("Oleg=7");
        do {
            System.out.println("Введите printvar или sortvar (или иной символ для завершения)");
            String choice = getOneLine();
            switch (choice){
                case "printvar":
                    System.out.println(Var.vars);
                    break;
                case "sortvar":
                    HashMap<String,Var> newVars = new HashMap<>();
                    newVars.putAll(Var.vars);


                    System.out.println(newVars);
                    break;
                    default: zxc = false;
            }
        }while (zxc);
    }
}
