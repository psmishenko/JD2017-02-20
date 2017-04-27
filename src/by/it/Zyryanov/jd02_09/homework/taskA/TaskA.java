package by.it.Zyryanov.jd02_09.homework.taskA;


import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/taskA/bookshop4.xsl"));
            transformer.transform(new StreamSource("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/taskA/BookShop.xml"), new StreamResult("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/taskA/BookShop.html"));
            System.out.println("Transform " + "/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/taskA/BookShop.xml" + " complete!");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
