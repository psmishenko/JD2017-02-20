package by.it.radivonik.jd02_10;

import by.it.radivonik.jd02_09.beans.*;
import com.google.gson.*;
import javax.xml.bind.*;
import java.io.*;

/**
 * Created by Radivonik on 19.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String filexml = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_09/naklads.xml";

        try {
            JAXBContext context = JAXBContext.newInstance(Naklads.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(filexml);
            Naklads naklads = (Naklads) unmarshaller.unmarshal(fileReader);
//            System.out.println(naklads);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(naklads,System.out);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().setPrettyPrinting().create();
            System.out.println(gson.toJson(naklads));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

