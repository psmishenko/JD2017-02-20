package by.it.kolenda.jd02_08;

import javax.xml.stream.*;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class STAXRunner {

    private static String fileNameXML = "src/by/it/kolenda/jd02_08/Clients.xml";

    public static void main(String[] args){

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

    try (FileInputStream fileInputStream = new FileInputStream(fileNameXML);){
        XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

        STAX instance = new STAX(reader);
        String txt = instance.parse();
        System.out.println(txt);
    }
    catch (XMLStreamException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
