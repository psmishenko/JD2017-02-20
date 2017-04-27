package by.it.smirnov.jd02_09.task_a;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by aleksey.smirnov on 19.04.2017.
 */
public class TaskA {
    private final static String path = System.getProperty("user.dir") + "/src/by/it/smirnov/jd02_09/task_a/";
    private final static String fileNameXML= path + "BankLimits.xml";
    private final static String fileNameXSL= path + "BankLimits.xsl";
    private final static String fileNameHTML= path + "BankLimits.html";

    public static void createAndShowHTMLfromXML() {

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(fileNameXSL));
            transformer.transform(new StreamSource(fileNameXML),
                    new StreamResult(fileNameHTML));
            System.out.println(String.format("Трансформация %s выполнена",fileNameXML));

            try {
                Desktop.getDesktop().open(new File(fileNameHTML));
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch(TransformerException e) {
            System.err.println(String.format("Ошибка трансформации %s : %s",fileNameXML, e.getMessage()));
        }
    }
}
