package by.it.psmishenko.jd03_2;

import by.it.psmishenko.jd03_2.beans.Book;
import by.it.psmishenko.jd03_2.beans.Role;
import by.it.psmishenko.jd03_2.beans.User;
import by.it.psmishenko.jd03_2.crud.BookCrud;
import by.it.psmishenko.jd03_2.crud.RoleCrud;
import by.it.psmishenko.jd03_2.crud.UserCrud;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.*;

/**
 * Created by GN on 04.05.2017.
 */
public class CrudTest {
    @Test
    public void testUCrud() throws SQLException {
        UserCrud userCrud = new UserCrud();
        User user = new User(25,"Test123","Test-pass","TestEmail",2);
        userCrud.create(user);
       User userEq = userCrud.read(user); // Test read
        assertEquals(user.getLogin(),userEq.getLogin()); // Проверка без id, т.к. оно AUTO_INCREMENT
        assertEquals(user.getPassword(),userEq.getPassword());
        assertEquals(user.getEmail(),userEq.getEmail());
        assertEquals(user.getFk_roles(),userEq.getFk_roles());
        user.setEmail("123");userEq.setEmail("123");
        userCrud.update(user); //test update
        user = userCrud.read(user);
        assertEquals(user.getEmail(),userEq.getEmail());
        userCrud.delete(user);
    }
    @Test
    public void testRCrud() throws SQLException {
        RoleCrud roleCrud = new RoleCrud();
        Role role = new Role(1,"TestRole");
        roleCrud.create(role);
        Role roleEq = roleCrud.read(role);
        assertEquals(role.getRole(),roleEq.getRole());
        role.setRole("LOLRole"); roleEq.setRole("LOLRole");
        roleCrud.update(role); role = roleCrud.read(role);
        assertEquals(role.getRole(),roleEq.getRole());
        roleCrud.delete(role);
    }
    @Test
    public void testBCrud() throws SQLException {
        BookCrud bookCrud = new BookCrud();
        Book book = new Book(1,"Test.Frog","67676767",20111,"123-44111-321",12336,2);
        bookCrud.create(book);
        Book bookEq = bookCrud.read(book);
        assertEquals(book.getAuthor(),bookEq.getAuthor());
        book.setAuthor("OLOLOL"); bookEq.setAuthor("OLOLOL");
        bookCrud.update(book); book = bookCrud.read(book);
        assertEquals(book.getAuthor(),bookEq.getAuthor());
        bookCrud.delete(book);
    }
}