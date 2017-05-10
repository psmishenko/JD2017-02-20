package by.it.zeynalov.jd02_08.HomeWork;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAX {

    public static void run(String fileXML) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(fileXML);) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            StAX instance = new StAX(reader);
            String txt = instance.parse();
            System.out.println(txt);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private XMLStreamReader reader;

    public StAX(XMLStreamReader reader) {
        this.reader = reader;
    }

    String parse() throws XMLStreamException {
        StringBuilder text = new StringBuilder();
        StringBuilder txtBuff = new StringBuilder();
        String tab = "";
        while (reader.hasNext()) {
            int operation = reader.next();
            switch (operation) {
                case XMLStreamConstants.START_ELEMENT:
                    String qName = reader.getLocalName();
                    int attCount = reader.getAttributeCount();
                    text.append(tab).append("<").append(qName);
                    for (int i = 0; i < attCount; i++) {
                        String name = reader.getAttributeLocalName(i);
                        String value = reader.getAttributeValue(i);
                        text.append(" ").append(name).append("=\"").append(value).append("\"");
                    }
                    text.append(">\n");
                    tab = tab + "\t";
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    String qName2 = reader.getLocalName();
                    String tx = txtBuff.toString().trim();
                    if (tx.length() > 0)
                        text.append(tab).append(tx).append("\n");
                    txtBuff.setLength(0);
                    tab = tab.substring(1);
                    text.append(tab).append("</").append(qName2).append(">\n");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String part = reader.getText();
                    txtBuff.append(part);
                    break;
            }
        }

        return text.toString();

    }

}
