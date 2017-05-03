package by.it.psmishenko.jd03_3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 02.05.2017.
 */
public class ShowUsers {

   public static  void showAllUsers() throws SQLException {
        StringBuilder res = new StringBuilder();
        res.append(String.format("%10s%20s%20s%30s%20s\n","User ID","Login","Password","Email","Role (ID)"));
       String sql1 = "SELECT * FROM `users` INNER JOIN roles ON users.FK_roles = roles.ID";
       String sql2 = "SELECT COUNT(*) FROM `users`";
       String sql3 = "SELECT COUNT(*) FROM `roles`";
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql1);
            while (resultSet.next()){
                res.append(String.format("%10d%20s%20s%30s%20s\n", resultSet.getInt(1),
                        resultSet.getString("Login"),resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getString("Role")+" ("+resultSet.getInt("FK_roles")+")"));
            }
            ResultSet resultSet1 = statement.executeQuery(sql2);
            while (resultSet1.next()){
                res.append("Число пользователей - "+resultSet1.getInt("COUNT(*)")+"\n");
            }
            ResultSet resultSet2 = statement.executeQuery(sql3);
            while (resultSet2.next()){
                res.append("Число возможных ролей - "+resultSet2.getInt("COUNT(*)"));
            }
            System.out.println(res);
        }
        }
    }
