package by.it.korzun.jd02_09.xpath;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertToHtml {
    public static void run() {
        String converterpath = "src/by/it/korzun/jd02_09/xpath/Brigades.xsl";
        String xmlpath = "src/by/it/korzun/jd02_09/xpath/Brigades.xml";
        String htmlpath = "src/by/it/korzun/jd02_09/xpath/Result.html";

        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(converterpath));
            transformer.transform(new StreamSource(xmlpath), new StreamResult(htmlpath));
            System.out.println("Converted");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
