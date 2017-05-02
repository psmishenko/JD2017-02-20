package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.beans.Role;
import by.it.loktev.jd03_02.crud.ConnectorCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskB {

    public static void run() throws SQLException {

        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            ResultSet usersResultSet = statement.executeQuery("select u.login, r.name role_name from users u, roles r where u.roleid=r.id;");
            int usersCount=0;
            while (usersResultSet.next()) {
                String login = usersResultSet.getString("login");
                String roleName=usersResultSet.getString("role_name");

                System.out.println("Пользователь: " + login+" роль: "+roleName);

                usersCount++;
            }

            ResultSet rolesResultSet = statement.executeQuery("select count(*) cnt from roles;");
            rolesResultSet.next();
            int rolesCount=rolesResultSet.getInt("cnt");

            System.out.println("Всего пользователей: "+usersCount+", возможных ролей: "+rolesCount);
        }


    }

}
