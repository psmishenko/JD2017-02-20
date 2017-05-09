package by.it.prigozhanov.jd03_02.test_crud;

import by.it.prigozhanov.jd03_02.beans.Role;
import by.it.prigozhanov.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

/**
 * Created by v-omf on 4/29/2017!
 */
public class TestRole {

    public static void main(String[] args) throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        Role role = new Role(3, "Administrator");
        if (roleCRUD.create(role)) {
            System.out.println("CREATED: "+ role);
        };

        if (role != null) {
            System.out.println("READ: "+roleCRUD.read(role));
        }

        if (roleCRUD.update(role)) {
            System.out.println("UPDATED: "+role);
        }

        if(roleCRUD.delete(role)) {
            System.out.println("DELETED: "+role);
        }



    }

}
