package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.beans.Role;
import by.it.loktev.jd03_02.crud.RoleCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {

    public static void main(String[] args)  {

        try {

            System.out.println("\n=== Вариант A\n");

            RoleCRUD roleCRUD=new RoleCRUD();

            Role role1=new Role();
            role1.setId(1);
            role1=roleCRUD.read(role1);
            System.out.println("Прочитана роль по id: "+role1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

