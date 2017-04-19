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
                        if (text.length() > 0)
                            text.append("\n");
                        text.append(tab).append("<").append(reader.getLocalName());
                        for (int i = 0; i < reader.getNamespaceCount(); i++) {
                            String prefix = reader.getNamespacePrefix(i);
                            String val = reader.getNamespaceURI(i);
                            text.append(" xmlns").append(nsPrefix(prefix,true)).append("=\"").append(val).append("\"");
                        }
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            String prefix = reader.getAttributePrefix(i);
                            String name = reader.getAttributeLocalName(i);
                            String val = reader.getAttributeValue(i);
                            text.append(" ").append(nsPrefix(prefix,false)).append(name).append("=\"").append(val).append("\"");
                        }
                        text.append(">");
                        tab = tab + "\t";
                        value.setLength(0);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tab = tab.substring(1);
                        if (value.length() > 0)
                            text.append(value);
                        else
                            text.append("\n").append(tab);
                        text.append("</").append(reader.getLocalName()).append(">");
                        value.setLength(0);
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

    String nsPrefix(String prefix, boolean isNamespace) {
         if (prefix != null && !prefix.isEmpty()) {
             if (isNamespace)
                 return ":" + prefix;
             else
                 return prefix + ":";
         }
         else
            return "";
    }
}
