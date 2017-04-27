package by.it.radivonik.jd02_09;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TaskBC {
   public <T> void run(Class<T> classBean, String filexml) {
        try {
            JAXBContext context = JAXBContext.newInstance(classBean);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(filexml);
            T beans = (T) unmarshaller.unmarshal(fileReader);
            System.out.println("Демарашализация из XML:\n" + beans);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            System.out.println("Маршализация в XML:");
            marshaller.marshal(beans, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
