package by.it.kolenda.jd02_08;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;


public class SAXRunner {

    private static String filenameXML="src/by/it/kolenda/jd02_07/Clients.xml";

    public static void main(String[] args) {

        try {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    SAX handler = new SAX ();
    saxParser.parse(new File(filenameXML), handler);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (org.xml.sax.SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
