package by.it.radivonik.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class ConverterJsonToXml<T> extends AbstractConverter<T> {
    ConverterJsonToXml(Class<T> classBean) {
        super(classBean);
    }

    @Override
    public void buildConverter(String text) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().setPrettyPrinting().create();
        setBean(gson.fromJson(text, getClassBean()));
    }

    @Override
    public String convertToString() {
        StringWriter writer = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(getClassBean());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getBean(), writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
