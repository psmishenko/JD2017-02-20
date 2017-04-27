package by.it.Zyryanov.jd02_09.homework.bookpackage2;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskB {
    public static void main(String[] args) {

        try {
            JAXBContext jc = JAXBContext.newInstance(BookShop.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/bookpackage2/BookShop+XSD.xml");
            System.out.println("XML-файл прочитан");
            BookShop bookShop = (BookShop) u.unmarshal(reader);
            System.out.println(bookShop) ;

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bookShop, System.out);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(bookShop));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
