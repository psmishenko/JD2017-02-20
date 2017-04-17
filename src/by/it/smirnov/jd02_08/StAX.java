package by.it.smirnov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Реализация StAX
 */
public class StAX {
    public static void run(String fileNameXML){
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fis = new FileInputStream(fileNameXML)) {
            StAX.runStAX(inputFactory.createXMLStreamReader(fis));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runStAX(XMLStreamReader reader) throws XMLStreamException {
        StringBuilder text = new StringBuilder();
        StringBuilder buff = new StringBuilder();
        String tab = "";
        while (reader.hasNext()){
            int type=reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT :
                    text.append(tab).append("<").append(reader.getLocalName());
                    int attCount = reader.getAttributeCount();
                    for (int i = 0; i < attCount; i++) {
                        String name = reader.getAttributeLocalName(i);
                        String value = reader.getAttributeValue(i);
                        text.append(" ").append(name).append("=\"").append(value).append("\"");

                    }
                    text.append(">\n");
                    tab=tab+"\t";
                    break;
                case XMLStreamConstants.END_ELEMENT :
                    String part = buff.toString().trim();
                    if (part.length()>0)
                        text.append(tab).append(part).append("\n");
                    buff.setLength(0);
                    tab = tab.substring(1);
                    text.append(tab).append("</").append(reader.getLocalName()).append(">\n");
                    break;

                case XMLStreamConstants.CHARACTERS :
                    buff.append(reader.getText());
                    break;
            }
        }
        System.out.println(text);

    }

}
