package by.it.Zyryanov.jd02_10;



import by.it.Zyryanov.jd02_09.homework.bookpackage2.BookShop;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskA_B {

    public static void main(String[] args) {

        try {
            JAXBContext jc = JAXBContext.newInstance(BookShop.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd02_09/homework/bookpackage2/BookShop+XSD.xml");
            System.out.println("XML-файл прочитан");
            BookShop bookShop = (BookShop) u.unmarshal(reader);
            //XML to JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            System.out.println(gson.toJson(bookShop));

            String bookTitle = "Warhammer 40k";
            String description = "good book";
            String genre = "Novel";

            BookPOJO book = new BookPOJO(bookTitle, genre, description);

            String json = gson.toJson(book);
            System.out.println(json);

            BookPOJO bookPOJO2 = gson.fromJson(json, BookPOJO.class);
            System.out.println("\n\n bookPOJO2 = " + bookPOJO2.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

