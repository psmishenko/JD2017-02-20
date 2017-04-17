package by.it.prigozhanov.jd02_08;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by v-omf on 4/17/2017!
 */
public class StAX {

    private XMLStreamReader reader;
    private StringBuilder text = new StringBuilder();
    private StringBuilder txt;
    private String txtBuff;
    private String tab;

    public StAX(XMLStreamReader reader) {
        this.reader = reader;
    }

    void run() throws XMLStreamException {
        while (reader.hasNext()) {
            int operation=reader.next();
            switch (operation) {
                case XMLStreamConstants.START_ELEMENT:
                    String qName = reader.getLocalName();
                    int attCount=reader.getAttributeCount();
                    text.append(tab).append("<" + qName);
                    for (int i = 0; i < attCount; i++) {
                        String name = reader.getAttributeLocalName(i);
                        String value =reader.getAttributeValue(i);
                        text.append(" ").append(name).append("=\"").append(value).append("\"");
                    }
                    text.append(">\n");
                    tab=tab+"\t";
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    String qName2 = reader.getLocalName();
                    String tx=txtBuff.toString().trim();
                    if (txtBuff.length()>0)
                    {
                        text.append(tab).append(tx).append("\n");
                    }
                    tab=tab.substring(1);
                    text.append(tab).append("</").append(">\n");
                    break;

                case XMLStreamConstants.CHARACTERS:
                    System.out.println("CHARACTER");
                    break;
            }
        }
    }

}
