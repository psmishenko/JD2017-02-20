package by.it.sorokoee.jd02_09;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TestHtml {
    private final static String path="src/by/it/sorokoee/jd02_09/";
    public static void main(String[ ] args) {
        String fileXML=path+"Persons1.xml";
        String fileHTML=path+"Persons1.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(path+"Persons1.xsl"));
            transformer.transform(new StreamSource(fileXML),
                    new StreamResult(fileHTML));
            System.out.println("Преобразование " + fileXML + " в "+fileHTML+ " выполнено");
        } catch(TransformerException e) {
            System.err.println("Невозможно преобразование файла " + fileXML + " : " + e);
        }
    }
}
