package by.it.Zyryanov.jd02_08.classwork;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StaxRunner {

    private static String filenameXML="src/by/it/Zyryanov/jd02_08/classwork/BookShop.xml";

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(filenameXML);) {
                    XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

        STAX instance = new STAX(reader);
            instance.run();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
