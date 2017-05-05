package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class A_AddUser {
    public void run() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        statement.executeUpdate("DELETE FROM sklad WHERE id_user IN (100, 101)");
        statement.executeUpdate("DELETE FROM user WHERE id IN (100, 101)");
        statement.executeUpdate(
            "INSERT INTO user (id, login, password, email, id_role) VALUES (100, 'user1', 'password1', 'email1', 2)");
        statement.executeUpdate(
            "INSERT INTO user (id, login, password, email, id_role) VALUES (101, 'user2', 'password2', 'email1', 3)");
    }
}
