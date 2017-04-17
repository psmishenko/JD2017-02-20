package by.it.kolenda.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class STAXRunner {

    private static String fileNameXML = "src/by/it/kolenda/jd02_08/Clients.xml";

    public static void main(String[] args)

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        FileInputStream fileInputStream = new FileInputStream(fileNameXML);

        while (reader.hasNext());
        int operation = reader.next()
        switch (operation){
            case XMLStreamConstants.START_ELEMENT;
            case XMLStreamConstants.END_ELEMENT;
            case XMLStreamConstants.CHARACTERS;

        }


    }
}
