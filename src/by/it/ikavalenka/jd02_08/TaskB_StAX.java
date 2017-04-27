package by.it.ikavalenka.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

/**
 * Created by USER on 21.04.2017.
 */
public class TaskB_StAX {
    static String tab ="";

    public static void main(String[] args) {
        try{
            String fileName = "src/by/it/ikavalenka/jd02_08/InternetShop.xml";
            FileInputStream inputStream = new FileInputStream(fileName);
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
            String i1 = "";
            while (xmlStreamReader.hasNext()){
                int readerType=xmlStreamReader.next();
                switch (readerType){
                    case XMLStreamConstants.START_ELEMENT:
                    {
                        System.out.println(tab + "[" + xmlStreamReader.getLocalName() + "]");
                        for (int i = 0; i <xmlStreamReader.getAttributeCount() ; i++) {
                            System.out.println("["+xmlStreamReader.getAttributeName(i)+ ":" + xmlStreamReader.getAttributeValue(i) + "]");
                        }
                        tab = tab + "\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        i1 = i1.concat(xmlStreamReader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT:
                    {
                        if (!i1.isEmpty())
                            System.out.println(tab+i1);
                        tab=tab.substring(1);
                        i1 ="";
                        System.out.println(tab+"[/" + xmlStreamReader.getLocalName() + "]");
                        break;
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
