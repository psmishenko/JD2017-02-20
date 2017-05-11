package by.it.Zyryanov.jd03_02_unused.homework.test_crud;


import by.it.Zyryanov.jd03_02_unused.homework.beans.Roles;
import by.it.Zyryanov.jd03_02_unused.homework.crud.Roles_CRUD;

import java.sql.SQLException;

public class TestRoles {

    public static void main(String[] args) throws SQLException {

        Roles_CRUD roles_crud = new Roles_CRUD();
        Roles role = new Roles(22, "Buyer"); // тренировка создания, в проект скорее всего Buyer не пойдёт
        System.out.println(role);

        if (roles_crud.create(role)) {
            System.out.println("CREATE: " + role);
            role = roles_crud.read(role);
        }
        if (role != null) {
            System.out.println("READ: " + role);
        }
        if (roles_crud.update(role)) {
            System.out.println("UPDATE: " + role);
        }
        if (roles_crud.delete(role)) {
            System.out.println("DELETE: " + role);
        }
    }
}
