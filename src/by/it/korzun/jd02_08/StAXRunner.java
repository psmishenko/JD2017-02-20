package by.it.korzun.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAXRunner {

    private static String filenameXML = "src/by/it/korzun/jd02_08/XML.xml";

    public static void main(String[] args) {

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            FileInputStream fileInputStream = new FileInputStream(filenameXML);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            StAX instance = new StAX(reader);
            String txt = instance.run();
            System.out.println(txt);

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }


    }
}
