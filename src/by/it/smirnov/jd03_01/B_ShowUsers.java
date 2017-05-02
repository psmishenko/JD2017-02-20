package by.it.smirnov.jd03_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aleksey.smirnov on 29.04.2017.
 */
public class B_ShowUsers {
    public static void run() throws SQLException {
        StringBuilder sb = new StringBuilder();
        Connection connection = ConnectorCreator.getConnection();
        ResultSet resultUsers=connection.createStatement().executeQuery(
                "SELECT * FROM users"
        );
        while (resultUsers.next()) {
            sb.append("Пользователь: "+resultUsers.getString("name"));
            StringBuilder sbroles = new StringBuilder();
            ResultSet resultUsersRoles=connection.createStatement().executeQuery(
                    String.format("SELECT * FROM usersroles WHERE iduser=%d", resultUsers.getInt("id")));
            while (resultUsersRoles.next()) {
                ResultSet resultRoles=connection.createStatement().executeQuery(
                        String.format("SELECT * FROM roles WHERE id=%d", resultUsersRoles.getInt("idrole")));
                if (resultRoles.next()) {
                    if (sbroles.length()>0) {
                        sbroles.append("+");
                    }
                    sbroles.append(resultRoles.getString("name"));
                }
            }
            if (sbroles.length()>0) {
                sb.append(" Роли: "+sbroles.toString()+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
