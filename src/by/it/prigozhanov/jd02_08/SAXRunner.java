package by.it.prigozhanov.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by v-omf on 4/17/2017!
 */
public class SAXRunner {
    private static String filenameXML="src/by/it/prigozhanov/jd02_08/CarRental.xml";

    public static void main(String[] args) {


        try {

            SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
            SAXParser saxParser=saxParserFactory.newSAXParser();
            SAX handler=new SAX();
            File f=new File(filenameXML);
            saxParser.parse(f,handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }



    }
}
