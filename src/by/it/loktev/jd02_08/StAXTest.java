package by.it.loktev.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StAXTest {

    public static void run(String XMLFileName) {
        XMLInputFactory xif=XMLInputFactory.newInstance();
        try (
            FileInputStream fis=new FileInputStream(XMLFileName);
        ) {
            XMLStreamReader reader=xif.createXMLStreamReader(fis);
            StAXHandler stax=new StAXHandler(reader);
            String res=stax.parse();
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
