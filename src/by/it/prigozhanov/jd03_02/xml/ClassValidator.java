package by.it.prigozhanov.jd03_02.xml;

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
 * Created by v-omf on 4/14/2017!
 */
public class ClassValidator {
    public static void main(String[] args) {
        String path = System.getProperty("user");
        String xmlfile="src/by/it/prigozhanov/jd02_09/CarRental+XSD.xml";
        String sname="src/by/it/prigozhanov/jd02_09/CarRental.xsd";
        String lang= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(sname);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlfile);

            validator.validate(source);
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.println("Invalid");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error");
        }
    }
}
