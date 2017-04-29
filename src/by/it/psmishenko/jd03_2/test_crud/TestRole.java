package by.it.psmishenko.jd03_2.test_crud;

import by.it.psmishenko.jd03_2.beans.Role;
import by.it.psmishenko.jd03_2.crud.RoleCrud;

/**
 * Created by user on 29.04.2017.
 */
public class TestRole {
    public static void main(String[] args) {
        RoleCrud roleCrud = new RoleCrud();
        Role role = new Role(0,"Admin");
        roleCrud.create(role);
    }
}
