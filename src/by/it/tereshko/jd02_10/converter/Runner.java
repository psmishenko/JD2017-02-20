package by.it.tereshko.jd02_10.converter;

import by.it.tereshko.jd02_09.Persons;

import java.io.File;

public class Runner {

    public static void main(String[] args) {
        File file;
        String src = System.getProperty("user.dir") + "/src/by/it/tereshko/";
        ConverterFactory converterFactory = new ConverterFactory();

        //из XML-файла в JSON-текст
        AbstractConverter converter =
                converterFactory.createConverterBuilder("xml_to_json", Persons.class);
        file = new File(src + "jd02_09/Persons.xml");
        converter.buildConverter(file);
        String json = converter.getConverterResult();
        System.out.println("\nиз XML-файла в JSON-текст\n");
        System.out.println(json);

        //из XML-файла в JSON-файл
        file = new File(src + "jd02_10/json_data.json");
        converter.saveConverterResultToFile(file);

        //из JSON-файла в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml", Persons.class);
        file = new File(src + "jd02_10/json_data.json");
        converter.buildConverter(file);
        String xml = converter.getConverterResult();
        System.out.println("\nиз JSON-файла в XML-текст\n");
        System.out.println(xml);

        //из JSON-текста в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml", Persons.class);
        converter.buildConverter(json); //берем из предыдущего вызова конвертера
        xml = converter.getConverterResult();
        System.out.println("\nиз JSON-текста в XML-текст\n");
        System.out.println(xml);
    }

}