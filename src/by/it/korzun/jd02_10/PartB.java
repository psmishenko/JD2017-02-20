package by.it.korzun.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PartB {
    static File result = new File("src/by/it/korzun/jd02_10/FromJsonToXMLRes.xml");
    static void run(){
        System.out.println("Part B:");

        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(Brigades.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String path = "src/by/it/korzun/jd02_10/Brigades+XSD.xml";
            FileReader fileReader = new FileReader(path);
            Object o = unmarshaller.unmarshal(fileReader);
            Brigades brigades = (Brigades)o;
            System.out.println(brigades);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String str = gson.toJson(brigades);
            System.out.println(str);

            Brigades backWayBrigades = gson.fromJson(str, Brigades.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(backWayBrigades, result);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
