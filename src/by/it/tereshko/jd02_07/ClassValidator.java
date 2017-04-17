package by.it.tereshko.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ClassValidator {
    public static void main(String[] args) {
        String sname = "src/by/it/tereshko/jd02_07/Person.xsd";
        String xmlfile = "src/by/it/tereshko/jd02_07/Persons+xsd.xml";
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(sname);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlfile);
            validator.validate(source);
            System.out.println("Valid");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("Invalid");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error");
        }
    }
}
