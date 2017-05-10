package by.it.zeynalov.jd02_08.HomeWork;


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

public class DOM {

    public static void run(String fileXML) {
        try {
            DocumentBuilderFactory xml = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = xml.newDocumentBuilder();
            Document doc = db.parse(new File(fileXML));
            Element root = doc.getDocumentElement();
            child(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void child(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nd = nodeList.item(i);
            if (nd.getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nd;
                System.out.println(el.getTagName());
            }
            child(nd);
        }
    }
}

