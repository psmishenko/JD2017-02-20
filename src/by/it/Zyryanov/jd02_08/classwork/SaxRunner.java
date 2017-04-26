package by.it.Zyryanov.jd02_08.classwork;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;


public class SaxRunner {

    private static String filenameXML="src/by/it/Zyryanov/jd02_08/classwork/BookShop.xml";


    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX handler = new SAX();
            File f = new File(filenameXML);
            saxParser.parse(f, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
