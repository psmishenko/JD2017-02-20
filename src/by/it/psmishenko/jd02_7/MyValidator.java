package by.it.psmishenko.jd02_7;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 14.04.2017.
 */
public class MyValidator {
    public static void main(String[] args) {
        String lang = XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI;
        String sname = "D:\\students\\psmish\\JD2017-02-20\\src\\by\\it\\psmishenko\\jd02_7\\Books.dtd";
        String xmfile = "D:\\students\\psmish\\JD2017-02-20\\src\\by\\it\\psmishenko\\jd02_7\\Books.xml";
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(sname);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmfile);
            validator.validate(source);
            System.out.println("Valid");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
