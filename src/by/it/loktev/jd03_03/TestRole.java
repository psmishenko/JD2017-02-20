package by.it.loktev.jd03_03;

import by.it.loktev.jd03_03.DAO.RoleDAO;
import by.it.loktev.jd03_03.beans.Role;

import java.sql.SQLException;

public class TestRole {

    public static void run() throws SQLException {

        /*
        RoleDAO roleCRUD=new RoleDAO();
        Role role=new Role(1,"Администратор2");
        roleCRUD.create(role);
        */
        //roleCRUD.update(role);

        RoleDAO roleDAO=new RoleDAO();

        Role role1=roleDAO.read(1);
        System.out.println("Прочитана роль по id: "+role1);

    }



}
