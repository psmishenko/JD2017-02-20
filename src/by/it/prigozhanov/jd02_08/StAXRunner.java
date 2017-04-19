package by.it.prigozhanov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by v-omf on 4/17/2017!
 */
public class StAXRunner {

    private static String filenameXML = "src/by/it/prigozhanov/jd02_08/CarRental.xml";

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(filenameXML)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);
            
            StAX instance = new StAX(reader);

            instance.run();

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }


    }


}
