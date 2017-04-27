package by.it.smirnov.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Реализация DOM
 */
public class DOM {
    private static StringBuilder text;

    public static void run(String fileNameXML){
        text = new StringBuilder();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileNameXML));
            Element root = doc.getDocumentElement();
            printDOM("",root);
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void printDOM(String tab, Node el) {
        switch (el.getNodeType()) {
            case Node.ELEMENT_NODE :
                String nodeName = el.getNodeName();
                text.append(tab).append("<").append(nodeName);

                NamedNodeMap nnm = el.getAttributes();
                for (int i = 0; i < nnm.getLength(); i++) {
                    text.append(" ").append(nnm.item(i).getNodeName()).append("=\"").append(nnm.item(i).getNodeValue()).append("\"");
                }
                text.append(">\n");

                NodeList ns = el.getChildNodes();
                for (int i = 0; i < ns.getLength(); i++) {
                    printDOM(tab+"\t",ns.item(i));
                }
                text.append(tab).append("</").append(nodeName).append(">\n");
                break;
            case Node.TEXT_NODE :
                String nodeValue = el.getNodeValue();
                if (nodeValue != null && nodeValue.trim().length() > 0) {
                    text.append(tab).append(nodeValue).append("\n");
                }
                break;
        }
    }
}
