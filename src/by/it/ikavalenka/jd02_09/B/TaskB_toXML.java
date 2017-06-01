package by.it.ikavalenka.jd02_09.B;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by USER on 24.04.2017.
 */
public class TaskB_toXML {
    public static void main(String[] args) {
        try{
            JAXBContext context = JAXBContext.newInstance(InternetShop.class);
            Marshaller marshaller = context.createMarshaller();
            InternetShop internetShop = new InternetShop(){
                {
                    Administrator adm = new Administrator("zAds36","CatalogAll",12,"none","Order#1",123,"Normal",123,"Single","NONE");
                    this.add(adm);
                }
            };
            marshaller.marshal(internetShop, new FileOutputStream("src/by/it/ikavalenka/jd02_09/ToXML.xml"));
            System.out.println("Success");
        } catch (JAXBException e){
            System.out.println(e.toString());
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

    }
}
