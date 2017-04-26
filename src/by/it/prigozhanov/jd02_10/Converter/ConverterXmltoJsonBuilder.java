package by.it.prigozhanov.jd02_10.Converter;

import by.it.akhmelev.jd02_10.GSON_Demo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by v-omf on 4/26/2017.
 *
 * @author v-omf
 */
public class ConverterXmltoJsonBuilder extends AbstractConverter{


    public ConverterXmltoJsonBuilder(Class bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String text) {
        try {
            StringReader sr = new StringReader(text);
            JAXBContext jaxbContext = JAXBContext.newInstance(getBeanClass());
            Unmarshaller u = jaxbContext.createUnmarshaller();
            bean = u.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getConverterResult() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(getBean());
    }
}
