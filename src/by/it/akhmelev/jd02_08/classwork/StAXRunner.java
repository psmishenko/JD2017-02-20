package by.it.akhmelev.jd02_08.classwork;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXRunner {

    private static String filenameXML = "src/by/it/akhmelev/jd02_08/classwork/TestXML.xml";

    public static void main(String[] args) {
        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream=new FileInputStream(filenameXML);) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            StAX instance=new StAX(reader);
            String txt=instance.parse();
            System.out.println(txt);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
