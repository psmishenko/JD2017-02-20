package by.it.Zyryanov.jd02_08.homework;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParserV2 {

    public static Document document;
    //public static StringBuilder tagText;
    //public static StringBuilder descriptionText;

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File("src/by/it/Zyryanov/jd02_08/homework/BookShop.xml"));
            Element element = document.getDocumentElement();
            tagFinder(element);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void tagFinder(Node node) {
        //String text = node.getTextContent();
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node1 = list.item(i);
            if (node1.getNodeType() == Node.ELEMENT_NODE) {
                Element element1 = (Element) node1;
                System.out.println("<" + element1.getTagName() + ">");
//                if (text != null) {
//                    System.out.println("\t" + element1.getTextContent());
//                }
                tagFinder(node1);
            }
        }
    }
}