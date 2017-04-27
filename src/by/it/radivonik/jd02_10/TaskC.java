package by.it.radivonik.jd02_10;

import by.it.radivonik.jd02_10.beans.*;
import by.it.radivonik.jd02_10.converter.*;

import java.io.File;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TaskC {
    public void run(String filexml, String filejson) {
        ConverterFactory<Naklads> converterFactory = new ConverterFactory<Naklads>();
        AbstractConverter<Naklads> converter;

        System.out.println("XML->JSON:");
        System.out.println("файл->текст:");
        converter = converterFactory.createConverter(ConverterFactory.Direction.XML_TO_JSON,Naklads.class);
        converter.buildConverter(new File(filexml));
        String json = converter.convertToString();
        System.out.println(json);

        System.out.println("файл->файл:");
        String filejsonNew = filenameConvert(filejson);
        converter.convertToFile(new File(filejsonNew));
        System.out.println("см. файл " + filejsonNew);

        System.out.println("JSON->XML:");
        System.out.println("файл->текст:");
        converter = converterFactory.createConverter(ConverterFactory.Direction.JSON_TO_XML,Naklads.class);
        converter.buildConverter(new File(filejson));
        String xml = converter.convertToString();
        System.out.println(xml);

        System.out.println("текст->текст:");
        converter.buildConverter(json);
        xml = converter.convertToString();
        System.out.println(xml);

        System.out.println("текст->файл:");
        String filexmlNew = filenameConvert(filexml);
        converter.convertToFile(new File(filexmlNew));
        System.out.println("см. файл " + filexmlNew);
    }

    private String filenameConvert(String filename) {
        String pXml = "\\.xml$";
        String pJson = "\\.json$";
        if (filename.matches(".+" + pXml))
            return filename.replaceAll(pXml,"2.xml");
        else if (filename.matches(".+" + pJson))
            return filename.replaceAll(pJson,"2.json");
        else
            return null;
    }
}
