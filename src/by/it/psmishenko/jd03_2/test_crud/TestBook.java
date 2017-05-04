package by.it.psmishenko.jd03_2.test_crud;

import by.it.psmishenko.jd03_2.beans.Book;
import by.it.psmishenko.jd03_2.crud.BookCrud;

import java.sql.SQLException;

/**
 * Created by GN on 04.05.2017.
 */
public class TestBook {
  public static void run() throws SQLException {
      BookCrud bookCrud = new BookCrud();
      Book book = new Book(1,"S.Frog","LAlaland",2016,"123-444-321",123456,2);
      if(bookCrud.create(book)) System.out.println("Create book:"+book.getAuthor());
      book = bookCrud.read(book);
      if(book!=null) System.out.println("Read book:"+book.getAuthor());
      book.setAuthor("Ind.Frog");
      if(bookCrud.update(book)) System.out.println("Update book:"+book.getAuthor());
      if(bookCrud.delete(book)) System.out.println("deleted book");
  }
}
