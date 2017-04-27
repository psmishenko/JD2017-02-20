package by.it.radivonik.jd02_09;

import jdk.nashorn.internal.ir.CatchNode;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TaskA {
    public void run(String filexml) {
        String filexsl = filexml.replaceAll("\\.xml$",".xsl");
        String filehtml = filexml.replaceAll("\\.xml$",".html");
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(filexsl));
            transformer.transform(new StreamSource(filexml),new StreamResult(filehtml));
            System.out.println("Преобразование xml+xsl->html завершено:\nСм. файл " + filehtml);
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
