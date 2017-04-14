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
        String root = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_7\\";
        String sname = root+"Reader.xsd";
        String xmfile = root+"Readers+XSD.xml";
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
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
            System.out.println("INValid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
