package by.it.radivonik.jd02_08;

import javax.xml.stream.*;
import java.io.*;

/**
 * Created by Radivonik on 17.04.2017.
 */
public class StAX {
     public String parse(String filexml) {
        String tab = "";
        StringBuilder text = new StringBuilder("");
        StringBuilder value = new StringBuilder("");
        XMLStreamReader reader;

        try (FileInputStream fileStream = new FileInputStream(filexml)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            reader = inputFactory.createXMLStreamReader(fileStream);

            while (reader.hasNext()) {
                int operation = reader.next();
                switch (operation) {
                    case XMLStreamConstants.START_ELEMENT:
                        text.append(tab).append("<").append(reader.getLocalName());
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            String name = reader.getAttributeLocalName(i);
                            String val = reader.getAttributeValue(i);
                            text.append(" ").append(name).append("=\"").append(val).append("\"");
                        }
                        text.append(">").append("\n");
                        tab = tab + "\t";
                        value.setLength(0);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (value.length() > 0)
                            text.append(tab).append(value).append("\n");
                        value.setLength(0);
                        tab = tab.substring(1);
                        text.append(tab).append("</").append(reader.getLocalName()).append(">").append("\n");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String s = reader.getText();
                        value.append(s.trim());
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString();
    }
}
