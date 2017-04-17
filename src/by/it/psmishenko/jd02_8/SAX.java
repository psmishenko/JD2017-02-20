package by.it.psmishenko.jd02_8;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by user on 17.04.2017.
 */
public class SAX extends DefaultHandler {

    private StringBuilder text;
    private StringBuilder txtBuff;
    private String tab;


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start");
        text = new StringBuilder();
        txtBuff = new StringBuilder();
        tab = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(text.toString());
        System.out.println("END");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch,start,length);
        txtBuff.append(part);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      text.append(tab).append("<").append(qName);
        for (int i = 0; i <attributes.getLength() ; i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            text.append(" ").append(name).append("=\"").append(value).append("\"");
        }
        text.append(">").append("\n");
        tab = tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String tx = txtBuff.toString().trim();
        if(tx.length()>0)  text.append(tab).append(tx).append("\n");
        txtBuff.setLength(0); // delete
        tab = tab.substring(1);
        text.append(tab).append("</").append(qName).append(">").append("\n");
    }
}
