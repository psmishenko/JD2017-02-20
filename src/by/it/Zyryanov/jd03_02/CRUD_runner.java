package by.it.Zyryanov.jd03_02;




import by.it.Zyryanov.jd03_02.beans.Orders;
import by.it.Zyryanov.jd03_02.beans.Roles;
import by.it.Zyryanov.jd03_02.beans.Books;
import by.it.Zyryanov.jd03_02.beans.Users;
import by.it.Zyryanov.jd03_02.crud.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by georgijzyranov on 11.05.17.
 */
public class CRUD_runner {



    public static void main(String[] args) throws SQLException{


        Books_CRUD book = new Books_CRUD();
        Orders_CRUD order = new Orders_CRUD();
        Roles_CRUD role = new Roles_CRUD();
        Users_CRUD user = new Users_CRUD();

        C_Init.create();
        dbTableCreator.create();


        role.create(new Roles(0, "Admin"));
        role.create(new Roles(0, "User"));

        System.out.println("Roles created");

        user.create(new Users(0, "admin", "password", "adm@mail.ru", 1));
        user.create(new Users(0, "vova", "password", "vova@mail.ru", 2));
        user.create(new Users(0, "ivan123", "password", "ivan123@mail.ru", 2));

        System.out.println("Users created");

        book.create(new Books(0, "Book1", "Description", "Author1", 10));
        book.create(new Books(0, "Book2", "Description", "Author2", 11));
        book.create(new Books(0, "Book3", "Description", "Author3", 12));

        System.out.println("Books created");

        order.create(new Orders(0, 1, 1));

        System.out.println("Order created");

        UsersReader.read();


    }
}
