package by.it.Zyryanov.jd03_02_unused.homework.test_crud;


import by.it.Zyryanov.jd03_02_unused.homework.beans.Books;
import by.it.Zyryanov.jd03_02_unused.homework.crud.Books_CRUD;

import java.sql.SQLException;

public class TestBooks {

    public static void main(String[] args) throws SQLException{

        Books_CRUD books_crud = new Books_CRUD();
        Books book = new Books(454, "new book JD03_02", "no description", "George Zyryanov", 10);
        Books book1 = new Books(0, "Head first JAVA", "Nice book about JAVA", "no Author", 20);
        System.out.println(book + "\n" + book1);

        if (books_crud.create(book)){
            System.out.println("CREATE: " +book);
            book = books_crud.read(book);
        }
        if (books_crud.create(book1)){
            System.out.println("CREATE: " + book1); // добавим и оставим одну книгу в БД
        }
        if (book != null) {
            System.out.println("READ: " + book);
        }
        if (books_crud.update(book)){
            System.out.println("UPDATE: " + book);
        }
        if (books_crud.delete(book)){
            System.out.println("DELETE: " + book);
        }
    }
}
