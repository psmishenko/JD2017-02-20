package by.it.psmishenko.jd02_8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by GN on 17.04.2017.
 */
public class DOMRunner {
    private static String fileNameXML = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_8\\Test.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File(fileNameXML));
            Element element = document.getDocumentElement();
            DOM dom = new DOM();
            dom.parseDOM(element);

            }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

