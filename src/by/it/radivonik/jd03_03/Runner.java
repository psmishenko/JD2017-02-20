package by.it.radivonik.jd03_03;

import by.it.radivonik.jd03_03.beans.*;
import by.it.radivonik.jd03_03.dao.DAO;

import java.sql.SQLException;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class Runner {
    public static void main(String[] args) {
        DAO dao = DAO.getInstance();

        try {
            System.out.println("Вариант A");
            System.out.println("Список пользователей:\n" + dao.getUserRole().getAll(""));
            User user = new User(0, "user", "password", "user@mail.ru", 2);
            dao.getUser().create(user);
            System.out.println("Создание нового пользователя:\n" + dao.getUserRole().read(user.getId()));
            System.out.println("Список пользователей после создания пользователя:\n" + dao.getUser().getAll(""));
            user.setLogin("new_login");
            user.setPassword("new_password");
            dao.getUser().update(user);
            System.out.println("Изменение пользователя:\n" + dao.getUserRole().read(user.getId()));
            dao.getUser().delete(user);
            System.out.println("Список пользователей после удаления пользователя:\n" + dao.getUserRole().getAll(""));

            System.out.println("\nВариант B");
            System.out.println("См. реализацию класса DAO");

            System.out.println("\nВариант C");
            System.out.println("Не реализован");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
