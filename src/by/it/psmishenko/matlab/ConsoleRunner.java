package by.it.psmishenko.matlab;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ConsoleRunner {
    private static void oneRes(Var var, String expression){
        if (var != null) {
            System.out.println(expression+" = "+var);
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
     /* String levelA = "2.3+3";
      String levelB = "{1,2,3}/5";
      String levelC = "{{1,2},{4,5}}*{1,2}";
      oneRes(Parser.calc(levelA),levelA);
      oneRes(Parser.calc(levelB),levelB);
      oneRes(Parser.calc(levelC),levelC);*/
      // тестовые строки и операции для скаляров
       /* String num1 = "10.5"; String num2 = "5.5";
        oneRes(Parser.calc(num1+"+"+num2),num1+"+"+num2);
        oneRes(Parser.calc(num1+"-"+num2),num1+"-"+num2);
        oneRes(Parser.calc(num1+"*"+num2),num1+"*"+num2);
        oneRes(Parser.calc(num1+"/"+num2),num1+"/"+num2);*/
       // тестовые строки и операции для вектров
       /* String vec1 = "{2,3,4}"; String vec2 = "{4,5,6}";
        oneRes(Parser.calc(vec1+"+"+vec2),vec1+"+"+vec2);
        oneRes(Parser.calc(vec1+"-"+vec2),vec1+"-"+vec2);
        oneRes(Parser.calc(vec1+"*"+vec2),vec1+"*"+vec2);
        oneRes(Parser.calc(vec1+"+5"),vec1+"+5");
        oneRes(Parser.calc(vec1+"*5"),vec1+"*5");
        oneRes(Parser.calc(vec1+"/5"),vec1+"/5");*/
        // тестовые строки из jd01_09 для матриц
        String mat = "{{1,2},{8,3}}";
        oneRes(Parser.calc(mat+"+5"),mat+"+5");
        oneRes(Parser.calc(mat+"-5"),mat+"-5");
        oneRes(Parser.calc(mat+"*5"),mat+"*5");
        oneRes(Parser.calc(mat+"/5"),mat+"/5");
        oneRes(Parser.calc(mat+"*{1,2}"),mat+"*{1,2}");
        oneRes(Parser.calc(mat+"*"+mat),mat+"*"+mat);
        oneRes(Parser.calc(mat+"+"+mat),mat+"+"+mat);
        oneRes(Parser.calc(mat+"-"+mat),mat+"-"+mat);
        // операции присваивания
        Parser.calc("Ali=3");
        Parser.calc("Begemot={1,2,3,4}");
        Parser.calc("Alan=5");
        Parser.calc("Abed=7");
        Parser.calc("Aaa=7");
        Parser.calc("Aab=7");
        Parser.calc("Aac=7");
        do {
            System.out.println("Введите 1(printvar) или 2(sortvar) (или иной символ для завершения)");
            String choice = getOneLine();
            switch (choice){
                case "1":
                    System.out.println(Var.vars);
                    break;
                case "2":
                    Map<String,Var> newVars = new TreeMap<>(Var.vars);
                    //При добавлении объекта в дерево он сразу же размещается в
                   // необходимую позицию с учетом сортировки.
                    System.out.println(newVars);
                    break;
                    default: zxc = false;
            }
        }while (zxc);
    }
}
