package by.it.zeynalov.jd02_07.HomeWork;

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
        String name = "src\\by\\it\\zeynalov\\jd02_07\\HomeWork\\CoffeeHouse.xsd";
        String xmlfile = "src\\by\\it\\zeynalov\\jd02_07\\HomeWork\\CoffeeHouses+XSD.xml";
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(name);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlfile);
            validator.validate(source);
            System.out.println("Valid");
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("Invalid");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error");
        }
    }
}
