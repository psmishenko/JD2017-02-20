package by.it.loktev.jd02_07.XSD;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class valid {

    public static void main(String[] args) {
        String path=System.getProperty("user.dir");
        String sname=path+"/src/by/it/loktev/jd02_07/XSD/picture.xsd";
        String xname=path+"/src/by/it/loktev/jd02_07/XSD/picture.xml";
        String lang= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory=SchemaFactory.newInstance(lang);
        File schemaLocation=new File(sname);
        try {
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(xname);
            validator.validate(source);
            System.out.println("ВАЛИДЕН!");
        } catch (SAXException e) {
            System.out.println("НЕВАЛИДЕН!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
