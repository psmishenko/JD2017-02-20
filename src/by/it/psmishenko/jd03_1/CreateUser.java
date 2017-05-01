package by.it.psmishenko.jd03_1;

import java.sql.*;

/**
 * Created by user on 28.04.2017.
 */
public class CreateUser {

   static int createOneUser(String login,String pass, String email,int fk_role) {
       String sqlCreateUser =  String.format(" INSERT INTO `users`(`Login`, `Password`, `Email`, `FK_roles`) VALUES ('%s','%s','%s',%d)",
                login,pass,email,fk_role);
       String sqlSelect = "SELECT * FROM `users`";
       int id = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlCreateUser);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                if(resultSet.getString("Login").equals(login)) id = resultSet.getInt("ID");
            }
            System.out.println("Создан пользователь с логином "+login+" , ID = "+ id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
