package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TaskC {

    public static void run() {

        String BasePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_10/";
        String XMLInputFileName=BasePath+"input/picture.xml";
        String JSONOutputFileName=BasePath+"output/picture.json";

        StringBuffer sb_xml=new StringBuffer();
        try (
                FileReader fr = new FileReader(XMLInputFileName);
                BufferedReader bo = new BufferedReader(fr);
        ) {
            while ( bo.ready() ){
                sb_xml.append(bo.readLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=== Исходный XML:");
        System.out.println(sb_xml);

        Picture p=new Picture();
        ConverterFactory<Picture> cf=new ConverterFactory<Picture>();

        Converter conv1=cf.createConverter(p,"XML","JSON");
        String s_json=conv1.run(sb_xml.toString());
        System.out.println("=== После конвертации в JSON:");
        System.out.println(s_json);

        try (
                FileWriter fw = new FileWriter(JSONOutputFileName);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write(s_json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("=== JSON записан в output");

        Converter conv2=cf.createConverter(p,"JSON","XML");
        String s_xml=conv2.run(s_json);
        System.out.println("=== После обратной конвертации в XML:");
        System.out.println(s_xml);
    }
}


