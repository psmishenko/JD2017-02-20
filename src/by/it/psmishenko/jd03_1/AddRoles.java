package by.it.psmishenko.jd03_1;

import java.sql.*;

/**
 * Created by GN on 01.05.2017.
 */
public class AddRoles {
static int AddNewRole (String role){
    String sqlAddRole =  String.format("INSERT INTO `roles`(`Role`) VALUES ('%s')", role);
    String sqlSelect = "SELECT * FROM `roles`";
    int res = 0;
  /*  try {
        Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }*/
    try (
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlAddRole);
        ResultSet resultSet = statement.executeQuery(sqlSelect);
       while (resultSet.next()){
           if(resultSet.getString("Role").equals(role)) res = resultSet.getInt("ID");
       }
        System.out.println("Добавлена роль  "+role+" , ID = "+res);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return res;
}
}

