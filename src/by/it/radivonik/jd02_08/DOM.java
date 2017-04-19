package by.it.radivonik.jd02_08;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import java.io.IOException;

/**
 * Created by aleksandr.radivonik on 19.04.2017.
 */
public class DOM {
    private String tab;
    private StringBuilder text;

    public String parse(String filexml) {
        text = new StringBuilder("");
        tab = "";
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(filexml);
            Element element = document.getDocumentElement();
            parseNode(element);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();;
        }

        return text.toString();
    }

    private void parseNode(Node node) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                text.append(tab).append("<").append(node.getNodeName());
                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength() ; i++) {
                        Node atr = attributes.item(i);
                        text.append(" ").append(atr.getNodeName()).append("=\"").append(atr.getNodeValue()).append("\"");
                    }
                }
                text.append(">").append("\n");

                tab = tab + "\t";
                String value = node.getTextContent();
                if (value != null)
                    text.append(tab).append(value).append("\n");

                NodeList childrens = node.getChildNodes();
                for (int i = 0; i < childrens.getLength(); i++) {
                    parseNode(childrens.item(i));
                }
                tab = tab.substring(1);

                text.append(tab).append("</").append(node.getNodeName()).append(">").append("\n");
                break;
        }

    }
}
