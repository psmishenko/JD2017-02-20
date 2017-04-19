package by.it.prigozhanov.jd02_08;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by v-omf on 4/18/2017!
 */
public class DOMRunner {

    public static void main(String[] args) {
        String filenameXML = "src/by/it/prigozhanov/jd02_08/CarRental.xml";
        File myXML = new File(filenameXML);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;

        try {
            builder = factory.newDocumentBuilder();

            document = builder.parse(myXML);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DOM instance = new DOM(document);
        instance.run();
        instance.checkPriceList();
    }
}
