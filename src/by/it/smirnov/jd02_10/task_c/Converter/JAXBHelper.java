package by.it.smirnov.jd02_10.task_c.Converter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Класс вспомогательных функций JAXB
 */
public class JAXBHelper {
    public static Object Unmarshal(Class beanClass, String txtData) {
        Object bean = null;
        try {
            StringReader sr = new StringReader(txtData);
            JAXBContext jc = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            bean = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static String Marshal(Object bean){
        StringWriter sw = new StringWriter();
        try {
            JAXBContext  jc = JAXBContext.newInstance(bean.getClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }


}
