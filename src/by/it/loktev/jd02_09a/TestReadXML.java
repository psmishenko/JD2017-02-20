package by.it.loktev.jd02_09a;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestReadXML {

    public static void main(String[] args) {

        String XMLFileName=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_09a/group.xml";

        try {
            JAXBContext context=JAXBContext.newInstance(Group.class);
            Unmarshaller u=context.createUnmarshaller();
            FileReader fileReader=new FileReader(XMLFileName);
            Group picture=(Group)u.unmarshal(fileReader);
            System.out.println(picture);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
