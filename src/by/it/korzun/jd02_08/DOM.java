package by.it.korzun.jd02_08;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOM {

    static void run(String prefix, Node node){

        StringBuilder att = new StringBuilder();
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            att.append(" " + node.getAttributes().item(i).getNodeName() + "=\"" + node.getAttributes().item(i).getNodeValue() + "\"");
        }
        System.out.print(prefix + "<" + node.getNodeName() + att + ">\n");

        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                run(prefix + "\t", children.item(i));
            }else{
                String text = children.item(i).getNodeValue().trim();
                if(!text.equals("")){
                    System.out.print(prefix + "\t" + text + "\n");
                }
            }
        }

        System.out.print(prefix + "<\\" + node.getNodeName() + ">\n");

    }

}
