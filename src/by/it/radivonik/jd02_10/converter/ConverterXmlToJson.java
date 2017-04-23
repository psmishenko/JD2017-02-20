package by.it.radivonik.jd02_10.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class ConverterXmlToJson<T> extends AbstractConverter<T> {
    ConverterXmlToJson(Class<T> classBean) {
        super(classBean);
    }

    @Override
    public void buildConverter(String text) {
        try {
            StringReader reader = new StringReader(text);
            JAXBContext context = JAXBContext.newInstance(getClassBean());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            setBean((T)unmarshaller.unmarshal(reader));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String convertToString() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }
}
