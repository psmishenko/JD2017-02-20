package by.it.smirnov.jd02_04_matlab;

import by.it.smirnov.jd02_04_matlab.Log.ILog;
import by.it.smirnov.jd02_04_matlab.Log.Log;
import by.it.smirnov.jd02_04_matlab.Parser.Brackets;
import by.it.smirnov.jd02_04_matlab.Parser.Parser;
import by.it.smirnov.jd02_04_matlab.Storage.IStorage;
import by.it.smirnov.jd02_04_matlab.Storage.Storage;
import by.it.smirnov.jd02_04_matlab.Streams.ConsoleStream;
import by.it.smirnov.jd02_04_matlab.Streams.IStream;
import by.it.smirnov.jd02_04_matlab.Streams.StringStream;
import by.it.smirnov.jd02_04_matlab.Vars.Var;

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

        ILog log = new Log(System.getProperty("user.dir")+"/src/by/it/smirnov/jd02_04_matlab/log.txt", true);
        IStream inputStream = new StringStream();
        IStream outputStream = new ConsoleStream(log);
        IStorage storage = new Storage(log);
        String storageFileName = System.getProperty("user.dir")+"/src/by/it/smirnov/jd02_04_matlab/vars.txt";

        storage.loadFromFile(storageFileName);

        Parser parser=new Parser(inputStream, outputStream, storage, log);

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

        // Вариант B
        expression =
                        "C=B+(A*2)\n"+
                        "D=((C-0.15)-20)/(7-5)\n"+
                        "E={2,3}*(D/2)";
        inputStream.set(expression);
        parser.calculateAndPrint();
        inputStream.set("sortvar");
        parser.calculateAndPrint();


        // Вариант C
        expression =
                        "F={{1,2},{3,4}}*D/40.0";
        inputStream.set(expression);
        parser.calculateAndPrint();
        inputStream.set("sortvar");
        parser.calculateAndPrint();

        storage.saveToFile(storageFileName);

    }
}
