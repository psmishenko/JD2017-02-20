package by.it.Zyryanov.my_MatLab;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

public class ConsoleRunner {

    private static void oneRes(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }



    private static void printvar() {
        System.out.println(Var.varMap);
    }

    private static void sortvar() {
        System.out.println("Сортировка HashMap по алфавиту"); //непотребовало реализации, сортирует автоматически
        System.out.println(Var.varMap);
    }

    public static double StartTime(){
        double startTime = System.currentTimeMillis();
        return startTime;
    }

    public static double FinishTime(){
        double finishTime = System.currentTimeMillis();
        return finishTime;
    }


    public static void main(String[] args) {


        String fileOutHashMap = "/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/my_MatLab/vars.txt";
        Calculator calculator = new Calculator();
        calculator.calculate("A=9+4*2-8+10");
        calculator.calculate("B=4");
        calculator.calculate("C=3");
        calculator.calculate("D=99");
        calculator.calculate("E={3,3,3}");
        calculator.calculate("{3,3,3}+{3,3}");

        sortvar();

        LongReportBuilder longReport = new LongReportBuilder();
        ReportDirector reportDirector = new ReportDirector(longReport);
        reportDirector.makeReport();
        Report firstReport = reportDirector.getReport();


        System.out.println("Отчёт Построен");
        System.out.println(firstReport.getReportHeader());
        System.out.println("Начало работы "+firstReport.getReportStartTime());
        System.out.println(firstReport.getReportCalculations());
        System.out.println(firstReport.getReportResultOfCalculations());
        System.out.println("Конец работы " + firstReport.getReportFinishTime());


//        try {
//            PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileOutHashMap));
//            Iterator iterator = Var.varMap.entrySet().iterator();
//            while (iterator.hasNext()){
//                Map.Entry pair = (Map.Entry)iterator.next();
//                printWriter.print(pair.getKey().toString() + " " + pair.getValue());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
