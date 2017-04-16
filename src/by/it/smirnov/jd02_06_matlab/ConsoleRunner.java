package by.it.smirnov.jd02_06_matlab;

import by.it.smirnov.jd02_06_matlab.BuilderReport.*;
import by.it.smirnov.jd02_06_matlab.Log.SingleLogger;
import by.it.smirnov.jd02_06_matlab.Parser.Parser;
import by.it.smirnov.jd02_06_matlab.Storage.IStorage;
import by.it.smirnov.jd02_06_matlab.Storage.SingleStorage;
import by.it.smirnov.jd02_06_matlab.Streams.ConsoleStream;
import by.it.smirnov.jd02_06_matlab.Streams.IStream;
import by.it.smirnov.jd02_06_matlab.Streams.StringStream;
import by.it.smirnov.jd02_06_matlab.Vars.Var;

import static java.lang.Thread.sleep;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public class ConsoleRunner {
    private static void oneRes(Var var){
        if (var != null) {
            System.out.println(var);
        }
    }
    public static void main(String[] args) {

        IStream inputStream = new StringStream();
        IStream outputStream = new ConsoleStream(SingleLogger.getInstance());
        IStorage storage = SingleStorage.getInstance();

        String storageFileName = System.getProperty("user.dir")+"/src/by/it/smirnov/jd02_06_matlab/vars.txt";

        storage.loadFromFile(storageFileName);

        Parser parser=new Parser(inputStream, outputStream, storage, SingleLogger.getInstance());

        inputStream.set("sortvar");
        parser.calculateAndPrint();

/*
        // Вариант A
        inputStream.set("3.8+26.2");
        parser.calculateAndPrint();

        inputStream.set("87.4-23.1");
        parser.calculateAndPrint();

        inputStream.set("1.04*5.9");
        parser.calculateAndPrint();

        inputStream.set("12.7*5");
        parser.calculateAndPrint();

        inputStream.set("-6+12");
        parser.calculateAndPrint();

        inputStream.set("-7*3.1");
        parser.calculateAndPrint();

        inputStream.set("-4/8");
        parser.calculateAndPrint();

        // ***
        inputStream.set("-9-0.9");
        parser.calculateAndPrint();

        // Вариант B
        inputStream.set("{2,3,4}*2");
        parser.calculateAndPrint();

        inputStream.set("{2,3,4}/3");
        parser.calculateAndPrint();

        // ***
        inputStream.set("{2,3,4}-5");
        parser.calculateAndPrint();

        inputStream.set("-4+{2,3,4}");
        parser.calculateAndPrint();

        inputStream.set("{2,3,4}+{5,6,7}");
        parser.calculateAndPrint();

        // Вариант С
        inputStream.set("{{1,2},{8,3}}-2");
        parser.calculateAndPrint();

        inputStream.set("{{1,2},{8,3}}*{1,2}");
        parser.calculateAndPrint();

        inputStream.set("{{1,2},{8,3}}*{{1,2},{8,3}}");
        parser.calculateAndPrint();

        inputStream.set("{{1,2},{8,3}}+{{1,2},{8,3}}");
        parser.calculateAndPrint();

        inputStream.set("abc=5");
        parser.calculate();
        inputStream.set("err=5.259");
        parser.calculate();
        inputStream.set("dev={1,2}");
        parser.calculate();

        inputStream.set("res=1+2");
        parser.calculateAndPrint();

        inputStream.set("printvar");
        parser.calculateAndPrint();

        inputStream.set("sortvar");
        parser.calculateAndPrint();

        inputStream.set("err={{1,2,4},{8,3,5}}*{{1,2},{8,3}}");
        parser.calculate();
*/
        // Вариант A
        String expression =
                        "A=2+5.3\n"+
                        "B=A*3.5\n"+
                        "B1=B+0.11*-5\n"+
                        "B2=A/2-1";
        inputStream.set(expression);
        parser.calculateAndPrint();

        inputStream.set("sortvar");
        parser.calculateAndPrint();

        sleep(1000);
        // Вариант B
        expression =
                        "C=B+(A*2)\n"+
                        "D=((C-0.15)-20)/(7-5)\n"+
                        "E={2,3}*(D/2)";
        inputStream.set(expression);
        parser.calculateAndPrint();
        inputStream.set("sortvar");
        parser.calculateAndPrint();


        sleep(1000);
        // Вариант C
        expression =
                        "F={{1,2},{3,4}}*D/40.0";
        inputStream.set(expression);
        parser.calculateAndPrint();
        inputStream.set("sortvar");
        parser.calculateAndPrint();

        storage.saveToFile(storageFileName);

        Reporter reporter = new Reporter();
        AbstractBuilderReport br= new ShortBuilderReport();
        //AbstractBuilderReport br= new FullBuilderReport();
        reporter.setBuilderReport(br);
        reporter.makeReport();
        Report report = reporter.getReport();
        System.out.println(report);

    }

    protected static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
