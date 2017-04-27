package by.it.radivonik.jd02_08;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by Radivonik on 17.04.2017.
 */
public class SAX extends DefaultHandler {
    private String tab;
    private StringBuilder text;
    private StringBuilder value;

    public String parse(String filexml) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File(filexml),this);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    @Override
    public void startDocument() throws SAXException {
        text = new StringBuilder("");
        value = new StringBuilder("");
        tab = "";
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.println(text);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (text.length() > 0)
            text.append("\n");
        text.append(tab).append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            text.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        text.append(">");
        tab = tab + "\t";
        value.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tab = tab.substring(1);
        if (value.length() > 0)
            text.append(value);
        else
            text.append("\n").append(tab);
        text.append("</").append(qName).append(">");
        value.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        value.append(s.trim());
    }
}
