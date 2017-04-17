package by.it.psmishenko.jd02_8;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by user on 17.04.2017.
 */
public class SAXRunner {
    private static String fileNameXML = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_8\\Test.xml";

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX handler = new SAX();
            saxParser.parse(new File(fileNameXML),handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
