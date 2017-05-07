package by.it.prigozhanov.jd03_03.dao.tests;


import by.it.prigozhanov.jd03_03.beans.Role;
import by.it.prigozhanov.jd03_03.dao.RoleDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class RoleDAOTest {
    private static RoleDAO roleDAO = new RoleDAO();

    @Test
    public void testUser() throws Exception {
        Role role = new Role(1,"Test");
        assertTrue(roleDAO.create(role));
        assertNotNull(roleDAO.read(1));
        assertTrue(roleDAO.update(role));
        assertTrue(roleDAO.delete(role));
    }


}