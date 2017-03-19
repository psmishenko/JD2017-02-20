package by.it.smirnov.jd01_09;

import by.it.smirnov.jd01_09.Parser.Parser;
import by.it.smirnov.jd01_09.Storage.IStorage;
import by.it.smirnov.jd01_09.Storage.Storage;
import by.it.smirnov.jd01_09.Streams.ConsoleStream;
import by.it.smirnov.jd01_09.Streams.IStream;
import by.it.smirnov.jd01_09.Streams.StringStream;
import by.it.smirnov.jd01_09.Vars.Var;

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
        IStream outputStream = new ConsoleStream();
        IStorage storage = new Storage();

        Parser parser=new Parser(inputStream, outputStream, storage);
        Parser parserDebug=new Parser(inputStream, outputStream, storage, true);

        // Вариант A
        inputStream.set("3.8+26.2");
        parserDebug.calculateAndPrint();

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
        parserDebug.calculateAndPrint();

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
        parserDebug.calculateAndPrint();

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
        parserDebug.calculateAndPrint();

        inputStream.set("printvar");
        parser.calculateAndPrint();

        inputStream.set("sortvar");
        parser.calculateAndPrint();

    }
}
