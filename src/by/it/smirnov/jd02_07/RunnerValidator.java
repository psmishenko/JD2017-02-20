package by.it.smirnov.jd02_07;

/**
 * Класс валидации XML
 */
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class RunnerValidator {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir")+"/src/by/it/smirnov/jd02_07/XSD/";
        String xsdFileName = path + "BankLimits.xsd";
        String xmlFileName = path + "BankLimits.xml";

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File xsdLocation = new File(xsdFileName);
        try {
            Validator validator = factory.newSchema(xsdLocation).newValidator();
            validator.validate(new StreamSource(xmlFileName));
            System.out.println("Валидация прошла успешно");
        } catch (SAXException e) {
            System.err.println("Валидация прошла c ошибками:\n"+e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Ошибка");
        }
    }
}