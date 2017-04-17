package by.it.smirnov.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Реализация SAX
 */
public class SAX extends DefaultHandler {
    private StringBuilder text;
    private String tab;
    private StringBuilder buff;

    public static void run(String fileNameXML){
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SAX handler = new SAX();
            saxParser.parse(new File(fileNameXML),handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        text = new StringBuilder();
        buff = new StringBuilder();
        tab = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(text);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text.append(tab).append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            text.append(" ").append(name).append("=\"").append(value).append("\"");

        }
        text.append(">\n");
        tab=tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String part = buff.toString().trim();
        if (part.length()>0)
            text.append(tab).append(part).append("\n");
        buff.setLength(0);
        tab = tab.substring(1);
        text.append(tab).append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch,start,length);
        buff.append(part);
    }
}
