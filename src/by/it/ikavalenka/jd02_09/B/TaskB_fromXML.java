package by.it.ikavalenka.jd02_09.B;

        import javax.xml.bind.JAXBContext;
        import javax.xml.bind.JAXBException;
        import java.io.FileNotFoundException;
        import java.io.FileReader;
        import javax.xml.bind.Unmarshaller;
/**
 * Created by USER on 23.04.2017.
 */
public class TaskB_fromXML {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(InternetShop.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FileReader reader = new FileReader("src\\by\\it\\ikavalenka\\jd02_09\\InternetShop.xml");
            System.out.println("Proceed from XML completed");
            InternetShop internetShop = (InternetShop) unmarshaller.unmarshal(reader);
            System.out.println(internetShop);
        } catch (JAXBException e) {
            System.out.println(e.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
