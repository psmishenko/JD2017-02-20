package by.it.psmishenko.jd02_8;

import org.w3c.dom.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GN on 17.04.2017.
 */
public class DOM {
   private StringBuilder text = new StringBuilder() ;
   private String tab = "   ";
    public StringBuilder getText() {
        return text;
    }

    void parseDOM(Node node, String pr){
         String txt = node.getNodeValue();
         if(node.getNodeType()==node.ELEMENT_NODE) {
             text.append(pr).append("<").append(node.getNodeName());
             NamedNodeMap attributes = node.getAttributes();
             for (int i = 0; i <attributes.getLength() ; i++) {
                 Node nodeAttr = attributes.item(i);
                 text.append(" ").append(nodeAttr.getNodeName()).append("=").append("\"").append(nodeAttr.getNodeValue()).append("\"");
             }
             text.append(">").append("\n");
         }
        if(checkValue(txt)) {
          text.append(pr).append("    ").append(txt.trim()).append("\n");
        }
        NodeList ch = node.getChildNodes();
        for (int i = 0; i <ch.getLength() ; i++) {
            if (i==1) {
                tab+="   ";
            }
             parseDOM(ch.item(i),tab);
         }

         if(node.getNodeType()==node.ELEMENT_NODE) text.append(pr).append("</").append(node.getNodeName()).append(">").append("\n");
    }

    boolean checkValue (String str){
         if(str!=null){
        Pattern p = Pattern.compile("[\\w]");
        Matcher m = p.matcher(str);
        if(m.find()) return true;
        else return false;
    }else return false;
     }
}
