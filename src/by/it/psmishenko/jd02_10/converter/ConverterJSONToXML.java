package by.it.psmishenko.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by GN on 24.04.2017.
 */
public class ConverterJSONToXML extends AbstractConverter {
    public ConverterJSONToXML(Object bean) {
        super(bean);
    }

    public ConverterJSONToXML(Class beanClass) {
        super(beanClass);
    }

    @Override
    public void convert(String str) {
            Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
           bean = gson.fromJson(str,getBeanClass());

    }

    @Override
    public String getStringResults() {
       String res = null;
        try {
            JAXBContext context = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller =  context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(getBean(),stringWriter);
            res = stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res ;
    }
}
