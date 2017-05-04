package by.it.loktev.jd03_03c;

import by.it.loktev.jd03_03c.DAO.UniversalDAO;
import by.it.loktev.jd03_03c.beans.Role;

import java.sql.SQLException;

public class TestRole {

    public static void run() throws SQLException {

        UniversalDAO<Role> roleDAO=new UniversalDAO<Role>(Role.class,"roles");

        Role role1=roleDAO.read(1);
        System.out.println("Прочитана роль по id: "+role1);

    }



}
