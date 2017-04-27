package by.it.ikavalenka.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by USER on 21.04.2017.
 */
public class TaskC_DOM {
    public static void main(String[] args) {
        String fileName = "src/by/it/ikavalenka/jd02_08/InternetShop.xml";
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);
            Element el = document.getDocumentElement();
            printDomDoc("", el);
        }catch (Exception e){
            System.out.println("Error " + e.toString());
        }
    }
    private static void printDomDoc(String prefix, Node node){
        String textOne = node.getNodeValue();
        if (textOne!=null){
            System.out.println(prefix + textOne.trim());
            System.out.println();
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength() ; i++) {
            printDomDoc(prefix+node.getNodeName() + ">", children.item(i));
            NamedNodeMap namedNodeMap = node.getAttributes();
            if (node.getAttributes().getLength()>0)
                for (int j = 0; j <namedNodeMap.getLength() ; j++) {
                Node node1Attr = namedNodeMap.item(j);
                    System.out.println(node1Attr.getNodeName()+":"+node1Attr.getNodeValue());
                }
        }
    }
}
