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
            User user = new User(0, "user2", "password2", "user2@mail.ru", 2);
            dao.getUser().create(user);
            System.out.println(dao.getUser().getAll(""));
            System.out.println(dao.getUser().read(user.getId()));
            dao.getUser().delete(user);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
