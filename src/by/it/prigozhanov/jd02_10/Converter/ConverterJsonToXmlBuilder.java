package by.it.prigozhanov.jd02_10.Converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by v-omf on 4/26/2017.
 *
 * @author v-omf
 */
public class ConverterJsonToXmlBuilder extends AbstractConverter {


    public ConverterJsonToXmlBuilder(Class bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String text) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(text, getBeanClass());
    }

    @Override
    public String getConverterResult() {
        JAXBContext jc = null;
        StringWriter stringWriter = new StringWriter();
        try {
            jc = JAXBContext.newInstance(getBeanClass());
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getBean(), stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return stringWriter.toString();
    }
}
