package by.it.loktev.jd03_03;

import by.it.loktev.jd03_03.DAO.UserDAO;
import by.it.loktev.jd03_03.beans.User;

import java.sql.SQLException;

public class TestUser {

    public static void run() {

        User user = new User(0, "login", "pass", "email", 2);

        try {

            UserDAO userDAO = new UserDAO();

            //создание
            userDAO.create(user);
            System.out.println("created "+user);

            //чтение
            user=userDAO.read(user.getId());
            System.out.println("readed "+user);

            //обновление
            user.setLogin("loginUpdate");
            userDAO.update(user);
            user=userDAO.read(user.getId());
            System.out.println("updated "+user);

            //удаление
            userDAO.delete(user);
            System.out.println("deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
