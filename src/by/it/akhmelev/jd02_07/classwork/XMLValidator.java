package by.it.akhmelev.jd02_07.classwork;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {
        String sname = "src/by/it/akhmelev/jd02_07/classwork/Person.xsd";
        String xmlfile = "src/by/it/akhmelev/jd02_07/classwork/Persons+XSD.xml";
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
