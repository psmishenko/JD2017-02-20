package by.it.loktev.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

    private String CurrPrefix;
    private StringBuilder out;
    private StringBuilder txt;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        CurrPrefix="";
        txt=new StringBuilder();
        out=new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println(out);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        out.append("\n"+CurrPrefix+"<"+qName);
        for ( int i=0; i<attributes.getLength(); i++ ){
            String name=attributes.getLocalName(i);
            String value=attributes.getValue(i);
            out.append(" "+name+"=\""+value+"\"");
        }
        out.append(">");
        CurrPrefix+="\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);


        String txtStr=txt.toString().trim();
        txt.setLength(0);
        if ( txtStr.length()>0 ){
            out.append("\n"+CurrPrefix+txtStr);
        }

        CurrPrefix=CurrPrefix.substring(1);
        out.append("\n"+CurrPrefix+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        txt.append(ch, start, length);
    }
}
