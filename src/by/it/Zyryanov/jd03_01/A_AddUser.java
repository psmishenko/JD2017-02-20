package by.it.Zyryanov.jd03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

    public static void add() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB2, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO Users(Login, Password, Email, fk_Roles)\n" +
                    "VALUES ('George', 'password', 'george@example.com', 2);");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
