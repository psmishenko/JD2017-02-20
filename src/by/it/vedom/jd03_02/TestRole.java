package by.it.vedom.jd03_02;

import java.sql.SQLException;

public class TestRole {

    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD=new RoleCRUD();
        Role role=new Role(1,"Administrator");
        roleCRUD.create(role);
    }


}
