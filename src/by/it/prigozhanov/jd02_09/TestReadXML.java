package by.it.prigozhanov.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.fxml.JavaFXBuilderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class TestReadXML {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(CarList.class);
            Unmarshaller u = context.createUnmarshaller();
            String path = "src/by/it/prigozhanov/jd02_09/CarRental+XSD.xml";
            String fileName = "src/by/it/prigozhanov/jd02_09/GeneratedXMLfromPOJO.xml";

            FileReader fileReader = new FileReader(new File(path));
            Object o = u.unmarshal(fileReader);
            CarList carList = (CarList) o;
            System.out.println(carList);

            FileWriter fileWriter = new FileWriter(fileName);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(carList, fileWriter);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(carList));

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


