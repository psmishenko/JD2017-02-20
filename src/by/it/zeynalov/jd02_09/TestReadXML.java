package by.it.zeynalov.jd02_09;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestReadXML {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(. class);
            Unmarshaller u = context.createUnmarshaller();
            String path = "src/by/it/zeynalov/jd02_09/classwork/04+XSD.xml";

            FileReader fileReader = new FileReader(new File(path));
            Object o = u.unmarshal(fileReader);
            Students students = (Students) o;
            System.out.println(students);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(students, System.out);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(students));

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
