package by.it.loktev.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskB {

    public static void run() {

        String BasePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_10/";

        String XMLInputFileName=BasePath+"input/picture.xml";
        String XMLOutputFileName=BasePath+"output/picture.xml";

        try {
            JAXBContext context=JAXBContext.newInstance(Picture.class);
            Unmarshaller u=context.createUnmarshaller();
            FileReader fileReader=new FileReader(XMLInputFileName);
            Picture picture=(Picture)u.unmarshal(fileReader);

            System.out.println("=== из XML получен POJO-объект:");
            System.out.println(picture);

            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String pictureJSON=gson.toJson(picture);
            System.out.println("=== он же в формате JSON:");
            System.out.println(pictureJSON);

            Picture picture2=gson.fromJson(pictureJSON, Picture.class);
            System.out.println("=== из JSON получен POJO-объект:");
            System.out.println(picture2.toString());


            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            FileWriter XMLFileWriter=new FileWriter(XMLOutputFileName);
            marshaller.marshal(picture,XMLFileWriter);
            System.out.println("\nXML written to output folder");


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}


