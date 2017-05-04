package by.it.smirnov.jd03_03.Utils;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by aleksey.smirnov on 29.04.2017.
 */
public class ShowUsers {
    public static void run() throws SQLException {
        StringBuilder sb = new StringBuilder();
        int countUser = 0;
        Connection connection = ConnectorCreator.getConnection();
        ResultSet resultUsers=connection.createStatement().executeQuery(
                "SELECT * FROM users a"
        );
        while (resultUsers.next()) {
            sb.append("Пользователь: "+resultUsers.getString("name"));
            countUser ++;
            StringBuilder sbroles = new StringBuilder();
            ResultSet resultUsersRoles=connection.createStatement().executeQuery(
                    String.format("select b.name from usersroles a \n" +
                            " left join roles b on b.id=a.idrole\n" +
                            " where a.iduser=%d", resultUsers.getInt("id")));
            while (resultUsersRoles.next()) {
                if (sbroles.length()>0) {
                    sbroles.append("+");
                }
                sbroles.append(resultUsersRoles.getString("name"));
            }
            if (sbroles.length()>0) {
                sb.append(" Роли: "+sbroles.toString()+"\n");
            }
        }
        sb.append("-----------------------------------\n");
        sb.append("Количество пользователей: "+countUser+"\n");

        ResultSet resultRoles=connection.createStatement().executeQuery(
                "SELECT count(*) countroles FROM roles"
        );
        if (resultRoles.next()) {
            sb.append("Возможное количество ролей: "+resultRoles.getString("countroles")+"\n");
        }
        System.out.println(sb.toString());
    }
}
