package by.it.loktev.jd03_01;

import java.sql.*;

public class A_AddUser {

    public static void run(Connection connection, String login, String password, String email, int role) throws SQLException {

            Statement statement=connection.createStatement();
            statement.executeUpdate("INSERT INTO users (login, password, email, roleid) VALUES ('"+login+"', '"+password+"', '"+email+"', "+role+");");
/*
            Statement statement = connection.createStatement();) {
            //получаем пользователей
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") + ", " + resultSet.getString("Login");
                System.out.println(out);
                */
    }

}
