package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class B_ShowUsers {
    public void run() throws SQLException {
        int c = 0;
        Statement statementUser = ConnectionCreator.getConnection().createStatement();
        System.out.println("Список пользователей с ролями:");
        ResultSet rsUser = statementUser.executeQuery("SELECT * FROM user");
        while (rsUser.next()) {
            Statement statementRole = ConnectionCreator.getConnection().createStatement();
            ResultSet rsRole = statementRole.executeQuery("SELECT * FROM role WHERE id = " + rsUser.getString("id_role"));
            if (rsRole.next()) {
                System.out.printf("%s - %s\n", rsUser.getString("login"), rsRole.getString("name"));
                c++;
            }
        }
        System.out.printf("Итого записей: %d\n", c);
    }
}
