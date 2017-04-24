package by.it.psmishenko.jd02_10;

import by.it.psmishenko.jd02_10.converter.AbstractConverter;
import by.it.psmishenko.jd02_10.converter.ConverterFactory;
import java.io.File;
import java.util.Scanner;

/**
 * Created by GN on 22.04.2017.
 */
public class Runner {
    static  String XMLFile = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\Result.xml";
    public static void main(String[] args) {
       System.out.println("TaskA:");
        TaskA.runTaskA();
        System.out.println("\nTaskB:");
        TaskB.runTaskB();
        System.out.println("\nTaskC:");
        boolean zxc = true;
        System.out.println("Введите от 1 до 4:\n1 - xml to json (передаём в конструктор файл)\n"
                + "2 - json to xml (передаём в конструктор файл)\n" +
                        "3 - xml to json (передаём в конструктор строку)\n" +
                "4 - json to xml (передаём в конструктор строку)");
        ConverterFactory converterFactory = new ConverterFactory();
        String jsonString = null; String xmlString = null;
        do{
            String ch = new Scanner(System.in).nextLine();
            switch (ch){
                case "1":
                  AbstractConverter ac1 = converterFactory.createConverter("XML_To_JSON",Readers.class);
                    ac1.convert(new File(XMLFile));
                    jsonString = ac1.getStringResults();
                    System.out.println(jsonString);
                   ac1.saveResultsToFile(new File(
                           System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\TaskC#1.json"));

                    break;
                case "2":
                    AbstractConverter ac3 = converterFactory.createConverter("JSON_To_XML",Readers.class);
                    ac3.convert(new File(
                            System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\TaskC#1.json"));
                    ac3.saveResultsToFile(new File(
                            System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\TaskC#2.xml"));
                    xmlString = ac3.getStringResults();
                    System.out.println(xmlString);

                    break;
                case "3":
                    AbstractConverter ac2 = converterFactory.createConverter("XML_To_JSON",Readers.class);
                    ac2.convert(xmlString);
                    System.out.println(ac2.getStringResults());
                   /* ac2.saveResultsToFile(new File(
                            System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\TaskC#3.json"));*/
                    break;
                case "4":
                    AbstractConverter ac4 = converterFactory.createConverter("JSON_To_XML",Readers.class);
                    ac4.convert(jsonString);
                    System.out.println(ac4.getStringResults());
                   /* ac4.saveResultsToFile(new File(
                            System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\TaskC#4.xml"));*/
                    break;
                default: zxc = false;
            }
        }while (zxc);
    }
}
