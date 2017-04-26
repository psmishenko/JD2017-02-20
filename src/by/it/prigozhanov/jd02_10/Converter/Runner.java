package by.it.prigozhanov.jd02_10.Converter;

import by.it.prigozhanov.jd02_10.TaskB.Car;
import by.it.prigozhanov.jd02_10.TaskB.CarList;

import java.io.File;

/**
 * Created by v-omf on 4/26/2017.
 *
 * @author v-omf
 */
public class Runner {
    public static void main(String[] args) {
        File file;
        String src = System.getProperty("user.dir") + "/src/by/it/prigozhanov/";
        ConverterFactory converterFactory = new ConverterFactory();
        //XML TO JSON TEXT
        AbstractConverter converter = converterFactory.createConverterBuilder("xml_to_json", CarList.class);
        file = new File(src + "jd02_10/Converter/generate/CarRental.xml");
//        converter.buildConverter(file);
//        String json = converter.getConverterResult();
//        System.out.println("\nиз XML файла в JSON текст\n\n");
//        System.out.println(json);

        //XML TO JSON FILE

//        file = new File(src+"jd02_10/converter/generate/generated_json.json");
//        converter.saveConverterResultToFile(file);

        //JSON TO XML TEXT
        converter = converterFactory.createConverterBuilder("json_to_xml", CarList.class);
        file = new File(src + "jd02_10/Converter/generate/CarList.json");
        converter.buildConverter(file);
        String xml = converter.getConverterResult();
        System.out.println("\nиз JSON файла в XML текст\n\n");
        System.out.println(xml);

    }
}
