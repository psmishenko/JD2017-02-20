package by.it.loktev.jd02_09;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class Runner {

    public static void main(String[] args) {

        String BasePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_09/";
        String BasePath2="src/by/it/loktev/jd02_09/";

        String XMLInputFileName=BasePath+"input/picture.xml";
        String XMLOutputFileName=BasePath+"output/picture.xml";
        String JSONOutputFileName=BasePath+"output/picture.json";

        String XMLInputFileName2=BasePath+"input/picture2.xml";
        String XSLInputFileName=BasePath2+"input/picture.xsl";
        String HTMLOutputFileName=BasePath+"output/picture.html";

        try {
            JAXBContext context=JAXBContext.newInstance(Picture.class);
            Unmarshaller u=context.createUnmarshaller();
            FileReader fileReader=new FileReader(XMLInputFileName);
            Picture picture=(Picture)u.unmarshal(fileReader);

            System.out.println("=== toString:");
            System.out.println(picture);

            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            FileWriter XMLFileWriter=new FileWriter(XMLOutputFileName);
            marshaller.marshal(picture,XMLFileWriter);
            System.out.println("\nXML written to output folder");

            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            FileWriter JSONFileWriter=new FileWriter(JSONOutputFileName);
            JSONFileWriter.write(gson.toJson(picture));
            JSONFileWriter.close();
            System.out.println("\nJSON written to output folder");

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(XSLInputFileName));
            transformer.transform(new StreamSource(XMLInputFileName2), new StreamResult(HTMLOutputFileName));
            System.out.println("\nHTML written to output folder");

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(TransformerException e) {
            System.err.println("Impossible to transform file " + XMLInputFileName + " to HTML: " + e);
        }
    }

}
