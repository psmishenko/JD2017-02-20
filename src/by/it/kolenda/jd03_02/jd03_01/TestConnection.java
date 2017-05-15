package by.it.kolenda.jd03_02.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConnection {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ) {
            if (connection.isClosed()) {
                System.out.println("Connection closed");
            } else System.out.println("Connection open");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
