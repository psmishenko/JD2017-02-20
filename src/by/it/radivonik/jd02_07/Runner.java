package by.it.radivonik.jd02_07;

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
 * Created by Radivonik on 14.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_07";
        String filexml = path + "/naklads.xml";
        String filexsd = path + "/naklads.xsd";
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemaLocation = new File(filexsd);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filexml);
            validator.validate(source);
            System.out.println("Ура, товарищи!!!\nФайл " + filexml + " соответствует описанию " + filexsd);
        }
        catch (SAXException e) {
            System.out.println("Проверка на корректность " + filexml + " не вполнена: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println(filexml + " некорректен: " + e.getMessage());
        }
    }
}
