package by.it.smirnov.jd03_03.DAO;

import by.it.smirnov.jd03_03.UniversalDAO.UniversalDAO;
import by.it.smirnov.jd03_03.bean.*;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleksey.smirnov on 02.05.2017.
 */
public class DAOTest {
    @Test
    public void DAOTestUser() throws Exception {

        //UserDAO ud = DAO.getInstance().getUser();
        UniversalDAO<User> ud= DAO.getInstance().getUser();

        User newUser = new User(0, "Тестовый пользователь","smirnov_test","test");
        // create
        ud.create(newUser);
        // read
        User userRead = ud.read(newUser.getId());
        assertTrue(newUser.getId()==userRead.getId());
        assertTrue(newUser.getName().equals(userRead.getName()));
        assertTrue(newUser.getLogin().equals(userRead.getLogin()));
        assertTrue(newUser.getPassword().equals(userRead.getPassword()));
        assertEquals(newUser.toString(), userRead.toString());

        newUser.setName("Тестовый пользователь 2");
        newUser.setLogin("smirnov_test");
        newUser.setPassword("test2");
        // update
        ud.update(newUser);

        // read
        userRead = ud.read(newUser.getId());
        assertTrue(newUser.getId()==userRead.getId());
        assertTrue(newUser.getName().equals(userRead.getName()));
        assertTrue(newUser.getLogin().equals(userRead.getLogin()));
        assertTrue(newUser.getPassword().equals(userRead.getPassword()));
        assertEquals(newUser.toString(), userRead.toString());

        // delete
        ud.delete(userRead);
        userRead = ud.read(newUser.getId());
        assertTrue(userRead==null);
    }

    @Test
    public void DAOTestRole() throws Exception {
        RoleDAO rd = DAO.getInstance().getRole();
        Role newRole = new Role(0, "Тестовая роль");
        // create
        rd.create(newRole);
        // read
        Role roleRead = rd.read(newRole.getId());
        assertTrue(newRole.getId()==roleRead.getId());
        assertTrue(newRole.getName().equals(roleRead.getName()));
        assertEquals(newRole.toString(), roleRead.toString());

        newRole.setName("Роль тестовая");
        // update
        rd.update(newRole);

        // read
        roleRead = rd.read(newRole.getId());
        assertTrue(newRole.getId()==roleRead.getId());
        assertTrue(newRole.getName().equals(roleRead.getName()));
        assertEquals(newRole.toString(), roleRead.toString());

        // delete
        rd.delete(roleRead);
        roleRead = rd.read(newRole.getId());
        assertTrue(roleRead==null);
    }

    @Test
    public void DAOTestBank() throws Exception {
        SysOperDAO sod = DAO.getInstance().getSysOper();

        SysOper sysOper = new SysOper(0, 1, new Timestamp(System.currentTimeMillis()));
        sod.create(sysOper);

        CountryDAO cd = DAO.getInstance().getCountry();
        Country country = new Country(0,"Тестовая страна");
        cd.create(country);

        GroupBankDAO gbd = DAO.getInstance().getGroupBank();
        GroupBank groupBank = new GroupBank(0,"Тестовая группа");
        gbd.create(groupBank);

        BankDAO bd = DAO.getInstance().getBank();
        Bank newBank=new Bank(0,"БПС-Сбербанк TEST", country.getId(), "11-22-33",groupBank.getId(), sysOper.getId());
        // create
        bd.create(newBank);
        // read
        Bank readBank=bd.read(newBank.getId());
        assertEquals(newBank.toString(), readBank.toString());

        newBank.setName("БПС-Сбербанк");
        // update
        bd.update(newBank);
        // read
        readBank=bd.read(newBank.getId());
        assertEquals(newBank.toString(), readBank.toString());

        // delete
        bd.delete(newBank);
        readBank = bd.read(newBank.getId());
        assertTrue(readBank==null);

        gbd.delete(groupBank);
        GroupBank groupBankRead = gbd.read(groupBank.getId());
        assertTrue(groupBankRead==null);

        cd.delete(country);
        Country countryRead = cd.read(country.getId());
        assertTrue(countryRead==null);

        sod.delete(sysOper);
        SysOper sysOperRead = sod.read(sysOper.getId());
        assertTrue(sysOperRead==null);

    }

}
