package by.it.loktev.jd03_02;

import by.it.loktev.Calculator.*;
import by.it.loktev.jd03_02.beans.User;
import by.it.loktev.jd03_02.crud.UserCRUD;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CRUDTest {

    @Test
    public void testUserCRUD() {

        User user = new User(1000, "login", "pass", "email", 2);

        try {

            UserCRUD userCRUD = new UserCRUD();

            userCRUD.create(user);

            user = userCRUD.read(user);
            //System.out.println(user);
            assertEquals(user.toString(),"User{id=1000, login='login', password='pass', email='email', roleId=2}");

            //обновление
            user.setLogin("login2");
            user.setPassword("pass2");
            user.setEmail("email@gmail.com");
            user.setRoleId(1);
            userCRUD.update(user);
            user = userCRUD.read(user);
            //System.out.println(user);
            assertEquals(user.toString(),"User{id=1000, login='login2', password='pass2', email='email@gmail.com', roleId=1}");

            //удаление
            userCRUD.delete(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}