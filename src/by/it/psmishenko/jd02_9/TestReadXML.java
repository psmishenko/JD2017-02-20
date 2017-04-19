package by.it.psmishenko.jd02_9;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by user on 19.04.2017.
 */
public class TestReadXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Readers.class);
            Unmarshaller um = context.createUnmarshaller();
            String path = "D:\\students\\psmish\\JD2017-02-20\\src\\by\\it\\psmishenko\\jd02_9\\Readers+XSD.xml";
                FileReader fileReader = new FileReader(new File(path));
             Object o = um.unmarshal(fileReader);
            Readers readers = (Readers) o;
            System.out.println(readers+"\n lalalala \n");

            Marshaller marshaller =  context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(readers,System.out);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(readers));

        } catch (JAXBException e) {
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
