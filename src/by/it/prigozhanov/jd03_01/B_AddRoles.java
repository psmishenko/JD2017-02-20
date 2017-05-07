package by.it.prigozhanov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/30/2017!
 */
public class B_AddRoles {

    public static void add() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver couldn't load: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO roles(`Role`)" +
                    " VALUES ('Administrator')");
            System.out.println("Роль добавленна в базу данных");
                statement.executeUpdate("INSERT INTO roles(`Role`)" +
                        " VALUES ('Guest')");
            System.out.println("Роль добавленна в базу данных");



        } catch (SQLException e) {

        }


    }

}
