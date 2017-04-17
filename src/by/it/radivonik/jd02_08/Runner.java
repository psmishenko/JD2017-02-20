package by.it.radivonik.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Radivonik on 17.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String filexml = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_08/naklads.xml";

//        try {
//            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//            SAXParser saxParser = saxParserFactory.newSAXParser();
//            SAX handler = new SAX();
//            saxParser.parse(new File(filexml),handler);
//        }
//        catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//        catch (SAXException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try (FileInputStream file = new FileInputStream(filexml)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            XMLStreamReader reader = inputFactory.createXMLStreamReader(file);

            new StAX(reader).run();
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
