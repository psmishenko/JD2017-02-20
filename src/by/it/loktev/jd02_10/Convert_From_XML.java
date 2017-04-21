package by.it.loktev.jd02_10;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class Convert_From_XML<T> implements Convert_From<T> {

    public T run(String s, Class cls){

        Unmarshaller u= null;
        try {
            JAXBContext context=JAXBContext.newInstance(cls);
            u = context.createUnmarshaller();
            StringBuffer sb=null;
            return (T)u.unmarshal(new StringReader(s));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
