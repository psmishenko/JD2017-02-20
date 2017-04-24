package by.it.psmishenko.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;


/**
 * Created by GN on 24.04.2017.
 */
public class ConverterXMLToJSON extends AbstractConverter {
    public ConverterXMLToJSON(Object bean) {
        super(bean);
    }

    public ConverterXMLToJSON(Class beanClass) {
        super(beanClass);
    }

    @Override
    public void convert(String str) {
        try {
            JAXBContext  context = JAXBContext.newInstance(getBeanClass());
            Unmarshaller um = context.createUnmarshaller();
            StringReader stringReader = new StringReader(str);
           bean = um.unmarshal(stringReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getStringResults() {
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }
}
