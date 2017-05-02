package by.it.smirnov.jd03_02.crud;

import by.it.smirnov.jd03_02.bean.*;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aleksey.smirnov on 02.05.2017.
 */
public class CRUDTest {
    @Test
    public void CRUDTestUser() throws Exception {

        UserCrud uc = new UserCrud();

        User newUser = new User(0, "Тестовый пользователь","smirnov_test","test");
        // create
        uc.create(newUser);
        // read
        User userRead = uc.readById(newUser.getId());
        assertTrue(newUser.getId()==userRead.getId());
        assertTrue(newUser.getName().equals(userRead.getName()));
        assertTrue(newUser.getLogin().equals(userRead.getLogin()));
        assertTrue(newUser.getPassword().equals(userRead.getPassword()));
        assertEquals(newUser.toString(), userRead.toString());

        newUser.setName("Тестовый пользователь 2");
        newUser.setLogin("smirnov_test");
        newUser.setPassword("test2");
        // update
        uc.update(newUser);

        // read
        userRead = uc.readById(newUser.getId());
        assertTrue(newUser.getId()==userRead.getId());
        assertTrue(newUser.getName().equals(userRead.getName()));
        assertTrue(newUser.getLogin().equals(userRead.getLogin()));
        assertTrue(newUser.getPassword().equals(userRead.getPassword()));
        assertEquals(newUser.toString(), userRead.toString());

        // delete
        uc.delete(userRead);
        userRead = uc.readById(newUser.getId());
        assertTrue(userRead==null);
    }

    @Test
    public void CRUDTestRole() throws Exception {
        RoleCrud rc = new RoleCrud();
        Role newRole = new Role(0, "Тестовая роль");
        // create
        rc.create(newRole);
        // read
        Role roleRead = rc.readById(newRole.getId());
        assertTrue(newRole.getId()==roleRead.getId());
        assertTrue(newRole.getName().equals(roleRead.getName()));
        assertEquals(newRole.toString(), roleRead.toString());

        newRole.setName("Роль тестовая");
        // update
        rc.update(newRole);

        // read
        roleRead = rc.readById(newRole.getId());
        assertTrue(newRole.getId()==roleRead.getId());
        assertTrue(newRole.getName().equals(roleRead.getName()));
        assertEquals(newRole.toString(), roleRead.toString());

        // delete
        rc.delete(roleRead);
        roleRead = rc.readById(newRole.getId());
        assertTrue(roleRead==null);
    }

    @Test
    public void CRUDTestBank() throws Exception {
        SysOperCrud soc = new SysOperCrud();
        SysOper sysOper = new SysOper(0, 1, new Timestamp(System.currentTimeMillis()));
        soc.create(sysOper);

        CountryCrud cc = new CountryCrud();
        Country country = new Country(0,"Тестовая страна");
        cc.create(country);

        GroupBankCrud gbc = new GroupBankCrud();
        GroupBank groupBank = new GroupBank(0,"Тестовая группа");
        gbc.create(groupBank);

        BankCrud bc = new BankCrud();
        Bank newBank=new Bank(0,"БПС-Сбербанк TEST", country.getId(), "11-22-33",groupBank.getId(), sysOper.getId());
        // create
        bc.create(newBank);
        // read
        Bank readBank=bc.readById(newBank.getId());
        assertEquals(newBank.toString(), readBank.toString());

        newBank.setName("БПС-Сбербанк");
        // update
        bc.update(newBank);
        // read
        readBank=bc.readById(newBank.getId());
        assertEquals(newBank.toString(), readBank.toString());

        // delete
        bc.delete(newBank);
        readBank = bc.readById(newBank.getId());
        assertTrue(readBank==null);

        gbc.delete(groupBank);
        GroupBank groupBankRead = gbc.readById(groupBank.getId());
        assertTrue(groupBankRead==null);

        cc.delete(country);
        Country countryRead = cc.readById(country.getId());
        assertTrue(countryRead==null);

        soc.delete(sysOper);
        SysOper sysOperRead = soc.readById(sysOper.getId());
        assertTrue(sysOperRead==null);

    }

}
