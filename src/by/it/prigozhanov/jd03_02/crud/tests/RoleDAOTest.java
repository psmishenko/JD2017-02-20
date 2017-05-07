package by.it.prigozhanov.jd03_02.crud.tests;


import by.it.prigozhanov.jd03_02.beans.Role;
import by.it.prigozhanov.jd03_02.crud.RoleCRUD;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by v-omf on 5/2/2017.
 *
 * @author v-omf
 */
public class RoleDAOTest {
    private static RoleCRUD roleCRUD = new RoleCRUD();

    @Test
    public void testUser() throws Exception {
        Role role = new Role(1,"Test");
        assertTrue(roleCRUD.create(role));
        assertNotNull(roleCRUD.read(role));
        assertTrue(roleCRUD.update(role));
        assertTrue(roleCRUD.delete(role));
    }


}