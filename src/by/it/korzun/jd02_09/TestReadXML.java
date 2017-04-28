package by.it.korzun.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestReadXML {
    public static void run() {
        try {
            JAXBContext context = JAXBContext.newInstance(Brigades.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String path = "src/by/it/korzun/jd02_09/Brigades+XSD.xml";
            FileReader fileReader = new FileReader(path);
            Object o = unmarshaller.unmarshal(fileReader);
            Brigades brigades = (Brigades)o;
            System.out.println(brigades);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(brigades, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
