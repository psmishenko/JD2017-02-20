package by.it.loktev.jd03_02.test_crud;

import by.it.loktev.jd03_02.beans.Role;
import by.it.loktev.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

public class TestRole {

    public static void run() throws SQLException {

        /*
        RoleCRUD roleCRUD=new RoleCRUD();
        Role role=new Role(1,"Администратор2");
        roleCRUD.create(role);
        */
        //roleCRUD.update(role);

        RoleCRUD roleCRUD=new RoleCRUD();

        Role role1=new Role();
        role1.setId(1);
        role1=roleCRUD.read(role1);
        System.out.println("Прочитана роль по id: "+role1);

    }



}
