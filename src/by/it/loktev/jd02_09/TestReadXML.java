package by.it.loktev.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestReadXML {

    public static void main(String[] args) {

        String XMLFileName=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_09/picture.xml";

        try {
            JAXBContext context=JAXBContext.newInstance(Picture.class);
            Unmarshaller u=context.createUnmarshaller();
            FileReader fileReader=new FileReader(XMLFileName);
            Picture picture=(Picture)u.unmarshal(fileReader);
            System.out.println(picture);

            /*
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(picture,System.out);

            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(picture));
            */

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
