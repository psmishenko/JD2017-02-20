package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_02.beans.Role;
import by.it.radivonik.jd03_02.beans.User;
import by.it.radivonik.jd03_02.crud.RoleCRUD;
import by.it.radivonik.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        try {
            System.out.println("Вариант A");
            new TaskA().run();

            System.out.println("\nВариант B");
            new TaskB().run();

            System.out.println("\nВариант C");
            new TaskC().run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
