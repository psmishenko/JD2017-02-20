package by.it.loktev.jd03_03;

import by.it.loktev.jd03_03.DAO.DAO;
import by.it.loktev.jd03_03.DAO.RoleDAO;
import by.it.loktev.jd03_03.beans.Role;

import java.sql.SQLException;

public class TestRole {

    public static void run() throws SQLException {

        RoleDAO roleDAO=DAO.getInstance().getRole();

        Role role1=roleDAO.read(1);
        System.out.println("Прочитана роль по id: "+role1);

    }



}
