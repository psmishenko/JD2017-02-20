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
        StringBuilder sb_json=new StringBuilder(conv1.run(sb_xml.toString()));
        //System.out.println("=== После конвертации в JSON:");
        //System.out.println(sb_json);

    }
}


