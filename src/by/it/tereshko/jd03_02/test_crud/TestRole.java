package by.it.tereshko.jd03_02.test_crud;

import by.it.tereshko.jd03_02.beans.Role;
import by.it.tereshko.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

public class TestRole {

    public static void main(String[] args) throws SQLException {

        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role(0, "Administrator");
        roleCRUD.create(role);
    }

}