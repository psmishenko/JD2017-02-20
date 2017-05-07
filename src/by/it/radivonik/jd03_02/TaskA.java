package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.beans.User;
import by.it.radivonik.jd03_02.crud.RoleCRUD;
import by.it.radivonik.jd03_02.crud.UserCRUD;

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

        System.out.printf("Создание нового пользователя:\n");
        User user = new User(0, "new_login", "new_password", "new_email", new RoleCRUD().readByName("admin").getId());
        UserCRUD userCRUD = new UserCRUD();
        userCRUD.create(user);
        user = userCRUD.read(user);
        System.out.println(user);

        System.out.printf("Изменение пользователя:\n");
        user.setLogin("new_login_2");
        user.setPassword("new_password_2");
        user.setEmail("new_email_2");
        userCRUD.update(user);
        user = userCRUD.read(user);
        System.out.println(user);

        System.out.printf("Удаление пользователя:\n");
        userCRUD.delete(user);
        user = userCRUD.read(user);
        System.out.println(user);
    }
}
