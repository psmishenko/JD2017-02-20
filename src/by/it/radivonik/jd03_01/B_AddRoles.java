package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class B_AddRoles {
    public void run() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        statement.executeUpdate("DELETE FROM user WHERE id_role IN (100, 101)");
        statement.executeUpdate("DELETE FROM role WHERE id IN (100, 101)");
        statement.executeUpdate(
            "INSERT INTO role (id, name) VALUES (100, 'role_tes1')");
        statement.executeUpdate(
            "INSERT INTO role (id, name) VALUES (101, 'role_tes2')");
        statement.executeUpdate(
            "INSERT INTO user (id, login, password, email, id_role) VALUES (1000, 'user_role_test1', '111', 'email21', 100)");
        statement.executeUpdate(
            "INSERT INTO user (id, login, password, email, id_role) VALUES (1001, 'user_role_test2', '222', 'email22', 101)");
        System.out.println("Добавлены роли");
    }
}
