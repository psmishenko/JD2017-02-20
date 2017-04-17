package by.it.radivonik.jd02_08;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Radivonik on 17.04.2017.
 */
public class StAX {
    private XMLStreamReader reader;

    public StAX(XMLStreamReader reader) {
        this.reader = reader;
    }

    void run() {
        String tab = "";
        StringBuilder text = new StringBuilder("");
        StringBuilder value = new StringBuilder("");
        try {
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
            System.out.println(text);
        }
        catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
