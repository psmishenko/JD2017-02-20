package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.crud.RoleCRUD;

import java.sql.SQLException;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class TaskA {
    public void run() throws SQLException {
        String nameRole = "admin";
        Role role = new RoleCRUD().readByName(nameRole);
        System.out.printf("Поиск роли по имени ('%s'):\n", nameRole);
        if (role == null)
            System.out.printf("Роль: '%s' не найдена\n", nameRole);

        else
            System.out.printf("Роль: '%s', id: %d\n", role.getName(), role.getId());
    }
}
