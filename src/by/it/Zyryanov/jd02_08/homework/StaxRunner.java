package by.it.Zyryanov.jd02_08.homework;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StaxRunner {

    private static String filenameXML = "src/by/it/Zyryanov/jd02_08/homework/BookShop.xml";


    public static void main(String[] args) {


        XMLInputFactory inputFactory=XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream=new FileInputStream(filenameXML);) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            STAX instance=new STAX(reader);
            String txt=instance.parse();
            System.out.println(txt);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
