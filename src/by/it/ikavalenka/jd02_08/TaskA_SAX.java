package by.it.ikavalenka.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by USER on 21.04.2017.
 */
public class TaskA_SAX  extends DefaultHandler {
    public static void main(String[] args) {
        try{
            String fileName = "src/by/it/ikavalenka/jd02_08/InternetShop.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser =factory.newSAXParser();
            TaskA_SAX myImplSax = new TaskA_SAX();
            parser.parse(new File(fileName), myImplSax);
        } catch (Exception e){
            System.out.println("Error! "+e.toString());
        }
    }
    private String tab ="";
    private String value;


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty())
            System.out.println(tab + value);
        value ="";
        tab = tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(tab + "["+qName);
        for (int i = 0; i <attributes.getLength() ; i++) {
            String name = attributes.getLocalName(i);
            String  value = attributes.getValue(i);
            System.out.println(" "+ name +"="+value);
        }
        System.out.println("]");
        tab = '\t' +tab;
        value ="";
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        value = value.concat(new String(chars,i,i1).trim());
    }
}
