package by.it.prigozhanov.jd02_09.xpath;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by v-omf on 4/21/2017.
 *
 * @author v-omf
 */
public class TransformerXSL {
    final static String root ="src/by/it/prigozhanov/jd02_09/xpath/";

    public static void main(String[] args) {
        String fileName=root+"CarRental.xml";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root+"CarRental.xsl"));
            transformer.transform(new StreamSource(root+"carRental.xml"), new StreamResult(root+"xpath.html"));
            System.out.println("transform " + fileName + " complete!");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
