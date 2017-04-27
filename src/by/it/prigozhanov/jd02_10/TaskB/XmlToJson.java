package by.it.prigozhanov.jd02_10.TaskB;

import by.it.prigozhanov.Bank.Observer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by v-omf on 4/23/2017.
 *
 * @author v-omf
 */
public class XmlToJson {
    static String path = "D:/JAVA/Git/JD2017-02-20/src/by/it/prigozhanov/jd02_10/TaskB/";
    static String fileXML = path + "CarRental+XSD.xml";



    public static void main(String[] args) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(CarList.class);
            Unmarshaller um = jaxbContext.createUnmarshaller();
            Marshaller m = jaxbContext.createMarshaller();
            FileReader fr = new FileReader(new File(fileXML));
            Object o = um.unmarshal(fr);
            CarList carList = (CarList) o;
            System.out.println(o);

            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            System.out.println(gson.toJson(carList));

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
