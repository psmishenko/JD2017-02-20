package by.it.loktev.jd03_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B_ShowUsers {

    public static void run(Connection connection) throws SQLException {

        Statement usersStatement = connection.createStatement();
        ResultSet usersResultSet = usersStatement.executeQuery("select login, roleid from users;");
        while (usersResultSet.next()) {
            String login = usersResultSet .getString("login");
            int role = usersResultSet .getInt("roleid");
            String roleName="???";

            Statement roleStatement = connection.createStatement();
            ResultSet roleResultSet = roleStatement.executeQuery("select name from roles where id="+role+";");
            while (roleResultSet.next()) {
                roleName=roleResultSet.getString("name");
            }
            System.out.println("Пользователь: " + login+" роль: "+roleName);

        }

    }

}
