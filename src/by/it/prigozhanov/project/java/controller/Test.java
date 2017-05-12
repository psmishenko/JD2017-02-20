package by.it.prigozhanov.project.java.controller;


import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.dao.DAO;

import java.sql.SQLException;

/**
 * Created by v-omf on 5/12/2017.
 *
 * @author v-omf
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        User user = new User(1, "MP21313", "Petrov","12345678","petrov@mail.ru", 1);
        dao.user.update(user);
    }
}
