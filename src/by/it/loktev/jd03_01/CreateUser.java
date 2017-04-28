package by.it.loktev.jd03_01;

import java.sql.*;

public class CreateUser {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection=
                        DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        )
        {
            Statement statement=connection.createStatement();
            statement.executeUpdate("INSERT INTO user (login, password, email, fk_role) VALUES ('log3', 'pass3', 'admin3@tut.by', 1);");
/*
            Statement statement = connection.createStatement();) {
            //получаем пользователей
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") + ", " + resultSet.getString("Login");
                System.out.println(out);
                */
        } catch( SQLException e) {

        }
    }

}
