package by.it.radivonik.jd03_01;

import java.sql.*;

/**
 * Created by Radivonik on 28.04.2017.
 */
public class TestConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();;
        }

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/radivonik?useUnicode=true&characterEncoding=UTF-8",
                "root","")) {
            if (!connection.isClosed())
                System.out.println("open");
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO roles (id, role) VALUES (NULL, 'user')");
        }
        catch (SQLException e) {
            e.printStackTrace();;
        };
    }
}
