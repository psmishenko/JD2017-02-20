package by.it.sorokoee.jd03_02.TestCrud;


import by.it.sorokoee.jd03_02.crud.RoleCrud;
import by.it.sorokoee.jd03_02.beans.Role;

import java.sql.SQLException;

public class TestRole {
    public static void main(String[] args) throws SQLException {
        RoleCrud roleCRUD=new RoleCrud();
        Role role=new Role(0,"Administrator");
        roleCRUD.create(role);
    }
}
