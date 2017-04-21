package by.it.psmishenko.jd02_9.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by user on 19.04.2017.
 */
public class XSLDemo {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\by\\it\\psmishenko\\jd02_9\\TaskA\\";
        String fileName = path + "Test.xml";
        String fileXSL = path + "Test.xsl";
        String fileHTML = path + "Test.html";
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(fileXSL));
            transformer.transform(new StreamSource(fileName), new StreamResult(fileHTML));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
