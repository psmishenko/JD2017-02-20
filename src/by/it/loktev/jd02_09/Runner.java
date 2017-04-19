package by.it.loktev.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class Runner {

    public static void main(String[] args) {

        String BasePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_09/";
        String XMLInputFileName=BasePath+"input/picture.xml";
        String XMLOutputFileName=BasePath+"output/picture.xml";
        String JSONOutputFileName=BasePath+"output/picture.json";

        try {
            JAXBContext context=JAXBContext.newInstance(Picture.class);
            Unmarshaller u=context.createUnmarshaller();
            FileReader fileReader=new FileReader(XMLInputFileName);
            Picture picture=(Picture)u.unmarshal(fileReader);
            System.out.println("=== toString:");
            System.out.println(picture);

            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            //System.out.println("=== XML output:");

            FileWriter XMLFileWriter=new FileWriter(XMLOutputFileName);
            marshaller.marshal(picture,XMLFileWriter);
            System.out.println("\nXML written to output folder");

            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            FileWriter JSONFileWriter=new FileWriter(JSONOutputFileName);
            JSONFileWriter.write(gson.toJson(picture));
            System.out.println("\nJSON written to output folder");
            JSONFileWriter.close();

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
