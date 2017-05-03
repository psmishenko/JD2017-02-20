package by.it.loktev.jd03_03c;

import by.it.loktev.jd03_03c.DAO.UniversalDAO;
import by.it.loktev.jd03_03c.beans.User;

import java.sql.SQLException;

public class TestUser {

    public static void run() {

        User user = new User(0, "login", "pass", "email", 2);

        try {

            UniversalDAO<User> userDAO=new UniversalDAO<User>(new User(),"users");

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
