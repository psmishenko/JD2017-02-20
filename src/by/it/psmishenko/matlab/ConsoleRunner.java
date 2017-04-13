package by.it.psmishenko.matlab;


import by.it.psmishenko.matlab.ReportPackage.FullReport;
import by.it.psmishenko.matlab.ReportPackage.ReportBuilder;
import by.it.psmishenko.matlab.ReportPackage.ReportDirector;
import by.it.psmishenko.matlab.ReportPackage.ShortReport;

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

    public static void main(String[] args) throws IOException,MathException {
        Timer t =new Timer();
        Parser parser = new Parser();
      //  Var vec1=new VarV("{1,5}");
       // Var vec2=new VarV("{1.7,2,3}");
        oneRes(parser.calc("A=2+5.3"),"A=2+5.3");
        oneRes(parser.calc("B=A*3.5"),"B=A*3.5");
        oneRes(parser.calc("B1=B-0.55"),"B1=B-0.55");
        oneRes(parser.calc("B2=A/2-1"),"B2=A/2-1");
        oneRes(parser.calc("{{1,2,3},{4,5,6}}/0"),"2:");
        oneRes(parser.calc("C=B+(A*2)"),"C=B+(A*2)");
        oneRes(parser.calc("D=((C-0.15)-20)/(7-5)"),"D=((C-0.15)-20)/(7-5)");
        oneRes(parser.calc("E={2,3}*(D/2)"),"E={2,3}*(D/2)");
        t.stopTimer(); // обработка всех операций закончена
        System.out.println("Time="+Timer.getDelta());
        ReportDirector reportDirector = new ReportDirector();
        ReportBuilder reportBuilder1 = new FullReport();
        ReportBuilder reportBuilder2 = new ShortReport();
        reportDirector.setReportBuilder(reportBuilder1);
        reportDirector.constructReport();
        reportDirector.setReportBuilder(reportBuilder2);
        reportDirector.constructReport();
       // IOData.loadFromTxt();
      //  System.out.println(Var.vars);
       // Parser.calc("Alfhfhfhf=3");
       // Parser.calc("Bjcjcjdeg={1,2,3,4}");
        //Parser.calc("Accccc=7");
        //IOData.saveVarInTxt();
       // boolean zxc = true;
        // тестовые строки из jd01_11
       /* System.out.println("Проверка деления на 0 для скаляров: 5/0"); oneRes(Parser.calc("5/0"),"1:");
        System.out.println("Проверка деления на ноль для векторов и матриц");
        oneRes(Parser.calc("{{1,2,3},{4,5,6}}/0"),"2:");
        oneRes(Parser.calc("{1,2,3}/0"),"3:");
        System.out.println("Проверка размерностей для векторов и матриц");
        oneRes(Parser.calc("{{1,2,3},{4,5,6}}+{{1,2},{1,2}}"),"4:");
        oneRes(Parser.calc("{1,2,3}*{4,4}"),"5:");
        oneRes(Parser.calc("{{1,2,3},{4,5,6}}*{1,2,3,4}"),"6:");
        System.out.println("Проверка правильности ввода переменной");
        oneRes(Parser.calc("{{1,2,3},{4,5,6}}*{1,2,3,4}"),"6:");*/

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
        oneRes(parser.calc(vec1+"+"+vec2),vec1+"+"+vec2);
        oneRes(parser.calc(vec1+"-"+vec2),vec1+"-"+vec2);
        oneRes(parser.calc(vec1+"*"+vec2),vec1+"*"+vec2);
        oneRes(parser.calc(vec1+"+5"),vec1+"+5");
        oneRes(parser.calc(vec1+"*5"),vec1+"*5");
        oneRes(parser.calc(vec1+"/5"),vec1+"/5");*/

        // тестовые строки из jd01_09 для матриц
     /*  String mat = "{{1,2},{8,3}}";
        oneRes(parser.calc(mat+"+5"),mat+"+5");
        oneRes(parser.calc(mat+"-5"),mat+"-5");
        oneRes(parser.calc(mat+"*5"),mat+"*5");
        oneRes(parser.calc(mat+"/5"),mat+"/5");
        oneRes(parser.calc(mat+"*{1,2}"),mat+"*{1,2}");
        oneRes(parser.calc(mat+"*"+mat),mat+"*"+mat);
        oneRes(parser.calc(mat+"+"+mat),mat+"+"+mat);
        oneRes(parser.calc(mat+"-"+mat),mat+"-"+mat);*/
        // операции присваивания

        /*do {
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
        }while (zxc);*/
    }
}
