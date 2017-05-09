package by.it.radivonik.jd03_02;

import by.it.radivonik.jd03_02.connection.ConnectionCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class TaskB {
    public void run() throws SQLException {
        int c = 0;
        Statement statementUser = ConnectionCreator.getConnection().createStatement();
        System.out.println("Список пользователей с ролями:");
        ResultSet rsUser = statementUser.executeQuery("SELECT u.login, r.name AS name_role FROM user u, role r WHERE u.id_role = r.id");
        while (rsUser.next()) {
            System.out.printf("%s - %s\n", rsUser.getString("login"), rsUser.getString("name_role"));
            c++;
        }
        System.out.printf("Итого пользователей: %d\n", c);
        ResultSet rsRole = statementUser.executeQuery("SELECT COUNT(*) AS count_role FROM role");
        if (rsRole.next())
            System.out.printf("Итого ролей: %d\n", rsRole.getInt("count_role"));
    }
}
