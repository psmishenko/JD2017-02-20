package by.it.psmishenko.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by GN on 22.04.2017.
 */
public class TaskB {

    static void runTaskB(){
        try {
            JAXBContext context = JAXBContext.newInstance(Readers.class);
            Unmarshaller um = context.createUnmarshaller();
            String XMLFile = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\Readers+XSD.xml";
            FileReader fileReader = new FileReader(new File(XMLFile));
            Object o = um.unmarshal(fileReader);
            Readers readers = (Readers)o ;
            System.out.println("XML to POJO:\n"+readers);
            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
            String taskBJSON = gson.toJson(readers);
            System.out.println("---XML->POJO->JSON--- \n"+taskBJSON);

            Readers readers1 = gson.fromJson(taskBJSON,Readers.class);
            Marshaller marshaller =  context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            System.out.println("JSON->POJO->XML");
            marshaller.marshal(readers1,System.out);
            String XMLResult = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_10\\Result.xml";
                marshaller.marshal(readers1,new FileWriter(XMLResult));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
