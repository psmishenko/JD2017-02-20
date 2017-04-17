package by.it.psmishenko.jd02_8;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by user on 17.04.2017.
 */
public class StAXRunner {
    private static String fileNameXML = System.getProperty("user.dir") + "\\src\\by\\it\\psmishenko\\jd02_8\\Test.xml";

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream(fileNameXML)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);
            StAX instance = new StAX(reader);
            instance.parse();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

