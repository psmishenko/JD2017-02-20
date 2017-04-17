package by.it.loktev.jd02_08;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMHandler {

    private StringBuilder out;

    public String print(Node rootNode) {
        out=new StringBuilder();
        print("",rootNode);
        return out.toString();
    }

    private void print(String CurrPrefix, Node node) {

        switch ( node.getNodeType() ){
            case Node.ELEMENT_NODE:
                Element elem=(Element)node;
                String tagName=elem.getTagName();
                out.append("\n"+CurrPrefix+"<"+tagName+">");
                NodeList children=node.getChildNodes();
                for ( int i=0; i<children.getLength(); i++ )
                    print(CurrPrefix+"\t",children.item(i));
                out.append("\n"+CurrPrefix+"</"+tagName+">");
                break;
            case Node.TEXT_NODE:
                String txt=node.getNodeValue().trim();
                if ( txt.length()>0 )
                  out.append("\n"+CurrPrefix+txt);
                break;
        }


    }

    /*

    private void startElement(String qName) {
        out.append("\n"+CurrPrefix+"<"+qName);

        int attCount=reader.getAttributeCount();
        for ( int i=0; i<attCount; i++ ){
            String name=reader.getAttributeLocalName(i);
            String value=reader.getAttributeValue(i);
            out.append(" "+name+"=\""+value+"\"");
        }

        out.append(">");
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
*/

}
