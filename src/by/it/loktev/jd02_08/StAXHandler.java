package by.it.loktev.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXHandler {

    private XMLStreamReader reader;
    private String CurrPrefix;
    private StringBuilder out;
    private StringBuilder txt;


    public StAXHandler(XMLStreamReader reader) {
        this.reader = reader;
    }

    public void run() throws XMLStreamException {
        CurrPrefix="";
        txt=new StringBuilder();
        out=new StringBuilder();
        while ( reader.hasNext() ){
            int oper=reader.next();
            switch ( oper ){
                case XMLStreamConstants.START_ELEMENT:
                    String tagName=reader.getLocalName();
                    startElement(tagName);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName=reader.getLocalName();
                    endElement(tagName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    characters(reader.getText());
                    break;
            }
        }
        System.out.println(out);
    }


    private void startElement(String qName) {
        out.append("\n"+CurrPrefix+"<"+qName);

        int attCount=reader.getAttributeCount();
        for ( int i=0; i<attCount; i++ ){
            String name=reader.getAttributeLocalName(i);
            String value=reader.getAttributeValue(i);
            out.append(" "+name+"=\""+value+"\"");
        }

        out.append(">");
        CurrPrefix+="\t";
    }

    private void endElement(String qName) {
        String txtStr=txt.toString().trim();
        txt.setLength(0);
        if ( txtStr.length()>0 ){
            out.append("\n"+CurrPrefix+txtStr);
        }

        CurrPrefix=CurrPrefix.substring(1);
        out.append("\n"+CurrPrefix+"</"+qName+">");
    }

    private void characters(String s) {
        txt.append(s);
    }


}
