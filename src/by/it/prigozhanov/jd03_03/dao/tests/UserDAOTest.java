package by.it.prigozhanov.jd03_03.dao.tests;


import by.it.prigozhanov.jd03_03.beans.User;
import by.it.prigozhanov.jd03_03.dao.UserDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class UserDAOTest {
    private static UserDAO userDAO = new UserDAO();

    @Test
    public void testUser() throws Exception {
        User user = new User(1, "PassportDataTest", "LoginTest", "PasswordTest", "EmailTest", 1, 1);
        assertTrue(userDAO.create(user));
        assertNotNull(userDAO.read(1));
        assertTrue(userDAO.update(user));
        assertTrue(userDAO.delete(user));
    }
}