package by.it.ikavalenka.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by USER on 23.04.2017.
 */
public class TaskA_to_HTML {
    public static void main(String[] args) {
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource("src\\by\\it\\ikavalenka\\jd02_09\\XML.xsl"));
            transformer.transform(new StreamSource("src\\by\\it\\ikavalenka\\jd02_09\\InternetShop.xml"), new StreamResult("src\\by\\it\\ikavalenka\\jd02_09\\InternetShop.html"));
            System.out.println("Transform completed");
        } catch (TransformerException e){
            e.printStackTrace();
        }
    }
}
