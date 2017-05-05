package by.it.kolenda.jd02_09;

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
    try {
        JAXBContext context = JAXBContext.newInstance(Clients.class);
        Unmarshaller um = context.createUnmarshaller();
        String path = "src/by/it/kolenda/jd02_09/Clients+XSD.xml";

        FileReader fileReader = new FileReader(path);
        Object o = um.unmarshal(fileReader);
        Clients clients = (Clients)o;
        System.out.println(clients);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(clients,System.out);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(clients));

    } catch (JAXBException e) {
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}
