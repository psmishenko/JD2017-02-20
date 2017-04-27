package by.it.loktev.jd02_10;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Convert_To_XML<T> implements Convert_To<T> {

    public String run(T obj, Class cls){
        try {
            JAXBContext context = JAXBContext.newInstance(cls);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            StringWriter sw=new StringWriter();
            marshaller.marshal(obj,sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

}
