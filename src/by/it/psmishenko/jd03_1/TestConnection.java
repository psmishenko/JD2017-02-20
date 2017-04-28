package by.it.psmishenko.jd03_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by GN on 28.04.2017.
 */
public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)
        ) {
            if (connection.isClosed()) {
                System.out.println("closed");
            }
            else
                System.out.println("open");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
