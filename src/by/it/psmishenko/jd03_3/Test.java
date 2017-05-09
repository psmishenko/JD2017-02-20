package by.it.psmishenko.jd03_3;

import by.it.psmishenko.jd03_3.beans.Book;
import by.it.psmishenko.jd03_3.beans.Role;
import by.it.psmishenko.jd03_3.beans.User;
import by.it.psmishenko.jd03_3.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by GN on 04.05.2017.
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        List<User> users = dao.user.getAll("");
        System.out.println(users);
        List<Role> roles = dao.role.getAll("");
        System.out.println(roles);
        List<Book> books = dao.book.getAll("");
        System.out.println(books);
        // Test Roles
        Role role = new Role(1,"Test123");
        if(dao.role.create(role)) System.out.println("Create role: "+dao.role.read(role.getId()));
        role.setRole("Test456");
        if(dao.role.update(role)) System.out.println("Updated: "+dao.role.read(role.getId()));
        if(dao.role.delete(role)) System.out.println("Deleted");
        // Test User
        User user = new User(0,"LTest","PTest","ETest",1);
        if(dao.user.create(user)) System.out.println("Create user: "+dao.user.read(user.getId()));
        user.setEmail("abra");
        if(dao.user.update(user)) System.out.println("update user: "+dao.user.read(user.getId()));
        if(dao.user.delete(user)) System.out.println("deleted user\n"+dao.user.getAll(""));
        // Test Book
        Book book = new Book(1,"S.Frog","LAlaland",2016,"123-444-321",123456,2);
        if(dao.book.create(book)) System.out.println("Create book: "+dao.book.read(book.getId()));
        book.setTitle("Lalalallnnnnnnd");
        if(dao.book.update(book)) System.out.println("upd book: "+dao.book.read(book.getId()));
        if(dao.book.delete(book)) System.out.println("deleted\n"+dao.book.getAll(""));
        ShowUsers.showAllUsers(dao.user.getAll(""),dao.role.getAll(""));
    }
}
