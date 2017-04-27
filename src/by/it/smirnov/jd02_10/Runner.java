package by.it.smirnov.jd02_10;

import by.it.smirnov.jd02_10.task_a.TaskA;
import by.it.smirnov.jd02_10.task_c.pojo_class.BankLimits;
import by.it.smirnov.jd02_10.task_b.TaskB;
import by.it.smirnov.jd02_10.task_c.Converter.AbstractConverter;
import by.it.smirnov.jd02_10.task_c.Converter.ConverterFactory;

import java.io.File;

import static by.it.smirnov.jd02_10.task_c.Converter.ConverterFactory.Direction.*;

/**
 * Класс запуска
 */
public class Runner {
    private final static String path = System.getProperty("user.dir") + "/src/by/it/smirnov/jd02_10/task_c/";
    private final static String fileNameXML = path + "BankLimits.xml";
    private final static String fileNameJSON = path + "BankLimits.json";
    private final static String fileNameNewXML = path + "BankLimitsNew.xml";

    public static void main(String[] args) {
        System.out.println("//////////////////////////////// Вариант A ////////////////////////////////");

        TaskA.pojoInJSON();
        TaskA.jsonInPOJO();

        System.out.println("//////////////////////////////// Вариант B ////////////////////////////////");

        TaskB.xmlToJSON();
        TaskB.jsonToXML();

        System.out.println("//////////////////////////////// Вариант C ////////////////////////////////");

        ConverterFactory converterFactory = new ConverterFactory();

        //из XML-файла в JSON
        AbstractConverter converter =
                converterFactory.createConverterBuilder(XML_TO_JSON,BankLimits.class);
        converter.buildConverter(new File(fileNameXML));
        System.out.println("\nиз XML-файла в JSON-текст\n");
        System.out.println(converter.getConverterResult());
        converter.saveToFileConverterResult(new File(fileNameJSON));
        System.out.println("\nJSON-файл сформирован\n");

        //из JSON-файла в XML
        converter =
                converterFactory.createConverterBuilder(JSON_TO_XML,BankLimits.class);
        converter.buildConverter(new File(fileNameJSON));
        System.out.println("\nиз JSON-файла в XML-текст\n");
        System.out.println(converter.getConverterResult());
        converter.saveToFileConverterResult(new File(fileNameNewXML));
        System.out.println("\nXML-файл сформирован\n");
    }
}
