package by.it.psmishenko.jd02_8;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by GN on 17.04.2017.
 */
public class DOM {
   public static StringBuilder text = new StringBuilder() ;
   private String tab = "\n";

     void parseDOM(Node node, String pr){
         String txt = node.getNodeValue();
        if(txt!=null) {
            text.append(pr).append(txt.trim());
        }
        NodeList ch = node.getChildNodes();
         for (int i = 0; i <ch.getLength() ; i++) {
             parseDOM(ch.item(i),tab+"<"+node.getNodeName()+">");

         }
    }

}
