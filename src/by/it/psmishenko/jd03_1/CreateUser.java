package by.it.psmishenko.jd03_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by user on 28.04.2017.
 */
public class CreateUser {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(
        Connection connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO `users` (`Login`, `Password`, `Email`, `FK_roles`) " +
                            "VALUES ('User','user','user@mail.ru',2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
