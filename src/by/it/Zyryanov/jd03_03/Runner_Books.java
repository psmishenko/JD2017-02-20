package by.it.Zyryanov.jd03_03;


import by.it.Zyryanov.jd03_03.beans.Books;
import by.it.Zyryanov.jd03_03.dao.Books_DAO;
import by.it.Zyryanov.jd03_03.dao.DAO;

import java.util.List;

public class Runner_Books {

    private static void showBooks() {
        System.out.println("\n Таблица всех книг");
        List<Books> books = new Books_DAO().getAll("");
        System.out.println("===================== Книги в БД ====================================================================");
        for (Books each: books) {
            System.out.println("|| "+ each);
            System.out.println("=====================================================================================================");
        }
    }


    public static void main(String[] args) {

        DAO dao = DAO.getDao();

        showBooks();

        Books book = new Books(8, "Artemis Fowl", "no description", "no author", 10);
        Books book1 = new Books(10, "Harry Potter", "no description", "J.K. Rowling", 5);

        if (dao.book.create(book)) {
            System.out.println("\n Добавлена новая книга: " + book);
        }
        if (dao.book.create(book1)){
            System.out.println("\n Добавлена новая книга: " + book1);
        }
        showBooks();

        book = dao.book.getAll("WHERE ID > 0").get(0);

        book.setAuthor("Eoin Colfer");

        if (dao.book.update(book)) {
            System.out.println("\n Обновлена информация о книге: " + book);
        }
        showBooks();

        if (dao.book.delete(book)) {
            System.out.println("\n Удалена книга: " + book);
        }
        showBooks();
    }
}
