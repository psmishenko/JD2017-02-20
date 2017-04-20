package by.it.prigozhanov.jd02_09;

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
 * Created by v-omf on 4/19/2017!
 */
public class TestReadXML {
    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(CarList.class);
            Unmarshaller u =context.createUnmarshaller();
            String path = "src/by/it/prigozhanov/jd02_09/CarRental+XSD.xml";
            FileReader fileReader = new FileReader(new File(path));
            Object o = u.unmarshal(fileReader);
            CarList carList = (CarList) o;

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(carList, System.out);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(carList));

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
