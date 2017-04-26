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
    private static String fileNameXML1 = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_8\\Test.xml"; // без атрибутов (моя предметная область)
    private static String fileNameXML2 = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\jd02_8\\Test2.xml"; // с атрибутами (произвольный xml файл)
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File(fileNameXML1));
            Element element = document.getDocumentElement();
            DOM dom = new DOM();
            dom.parseDOM(element,"");
            System.out.println("XML по моей предметной области (без атрибутов)\n"+dom.getText());
            Document document1 = builder.parse(new File(fileNameXML2));
            Element element1 = document1.getDocumentElement();
            DOM dom1 = new DOM();
            dom1.parseDOM(element1,"");
            System.out.println("Произвольный XML с атрибутами\n"+dom1.getText());
            }catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

