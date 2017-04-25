package by.it.ikavalenka.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by USER on 25.04.2017.
 */
public class Xml_to_json {
    public static void main(String[] args) {
        try{
            JAXBContext context = JAXBContext.newInstance(InternetShop.class);
            Unmarshaller unmarshaller =context.createUnmarshaller();
            FileReader reader = new FileReader("src\\by\\it\\ikavalenka\\jd02_10\\InternetShop.xml");
            InternetShop internetShop = (InternetShop) unmarshaller.unmarshal(reader);


            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String json = gson.toJson(internetShop);
            System.out.println("Transform to  JSON from XML");
            System.out.println(json);

            InternetShop internetShopDemo = gson.fromJson(json,InternetShop.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(internetShopDemo, new FileOutputStream("src\\by\\it\\ikavalenka\\jd02_10\\From_json.xml"));
        } catch (JAXBException e){
            System.out.println(e.toString());
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
}

