package by.it.psmishenko.jd03_1;

import java.sql.*;

/**
 * Created by GN on 01.05.2017.
 */
public class ShowUsers {
    static  void showAllUsers() {
        String sqlSelectAllUsers = "SELECT * FROM `users`";
        StringBuilder res = new StringBuilder();
        res.append(String.format("%20s%20s%30s%20s\n","Login","Password","Email","Role"));

        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSelectAllUsers);
            while (resultSet.next()) {
              res.append(String.format("%20s%20s%30s%20s\n",
                      resultSet.getString("Login"),resultSet.getString("Password"),
                        resultSet.getString("Email"),getRole(resultSet.getInt("FK_roles"))));
            }
            System.out.println(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
private static String getRole(int fk_role){
    String role ="";
  //  String sql1 = "SELECT `Role` FROM `roles` WHERE `ID` =";
     String sql2 = "SELECT * FROM `roles`";
    try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try (
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {
        ResultSet resultSet = statement.executeQuery(sql2);
        while (resultSet.next()) {
            if(resultSet.getInt("ID")==fk_role) role = resultSet.getString("Role");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return role;
}
}
