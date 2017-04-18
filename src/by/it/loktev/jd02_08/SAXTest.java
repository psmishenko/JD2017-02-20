package by.it.loktev.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAXTest {

    public static void run(String XMLFileName) {

        try {
            SAXParserFactory spf=SAXParserFactory.newInstance();
            SAXParser sp=spf.newSAXParser();
            SAXHandler sh=new SAXHandler();
            sp.parse(new File(XMLFileName),sh);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
