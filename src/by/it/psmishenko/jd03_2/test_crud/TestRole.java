package by.it.psmishenko.jd03_2.test_crud;

import by.it.psmishenko.jd03_2.beans.Role;
import by.it.psmishenko.jd03_2.crud.RoleCrud;

import java.sql.SQLException;

/**
 * Created by user on 29.04.2017.
 */
public class TestRole {
    public static void run() throws SQLException {
        RoleCrud roleCrud = new RoleCrud();
        Role role = new Role(0,"Admin123456");
        if(roleCrud.create(role)) System.out.println("Create new role:"+role.getRole()+" ID = "+role.getId());
        role = roleCrud.read(role);
        if(role!=null) System.out.println("read role:"+role.getRole()+" ID = "+role.getId());
        role.setRole("Admin789");
        if(roleCrud.update(role)) System.out.println("update:"+role.getRole());
        if(roleCrud.delete(role)) System.out.println("delete role");
        System.out.println("User ID = "+roleCrud.getRoleID("User"));
        System.out.println("Admin ID = "+roleCrud.getRoleID("Admin"));
    }
}
