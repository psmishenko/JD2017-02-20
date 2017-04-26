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

public class DomParser {
    public static void main(String[] args) {

        String bookNumAtr = "ISBN-10";
        String currency = "Currency";
        StringBuilder tab = new StringBuilder();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("src/by/it/Zyryanov/jd02_08/homework/BookShop.xml"));
            Element element = document.getDocumentElement();
            NodeList list = element.getChildNodes();
            System.out.println(tab + "<" + element.getTagName() + ">");
            for (int i = 0; i < list.getLength(); i++) {
                Node node1 = list.item(i);
                if (node1.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node1;
                    tab.append("\t");
                    System.out.println(tab.toString() + "<" + element1.getTagName() + ">");
                }
                NodeList list1 = node1.getChildNodes();
                tab.append("\t");
                for (int j = 0; j < list1.getLength(); j++) {
                    Node node2 = list1.item(j);
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        Element element2 = (Element) node2;
                        System.out.println(tab.toString() + "<" + element2.getTagName() + " ISBN-10 = " + element2.getAttribute(bookNumAtr) + ">");
                    }
                    NodeList list2 = node2.getChildNodes();
                    tab.append("\t");
                    for (int k = 0; k < list2.getLength(); k++) {
                        Node node3 = list2.item(k);
                        if (node3.getNodeType() == Node.ELEMENT_NODE) {
                            Element element3 = (Element) node3;
                            System.out.println(tab.toString() + "<" + element3.getTagName() + element3.getAttribute(currency) + ">" + "\n" + tab + "\t" + node3.getTextContent() + "\n" + tab + "</" + element3.getTagName()+ ">");
                        }
                    }
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        tab.deleteCharAt(3);
                        System.out.println(tab + "</" + node2.getNodeName() + ">");
                    }
                }
                if (node1.getNodeType() == Node.ELEMENT_NODE) {
                    tab.setLength(1);
                    System.out.println(tab.toString() + "</" + node1.getNodeName() + ">");
                }
            }
            tab.setLength(0);
            System.out.println(tab.toString() + "</" + element.getTagName() + ">");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}