package by.it.loktev.jd03_01;

import java.sql.*;

public class Runner {

    public static void main(String[] args)  {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection=DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB);
        )
        {

            System.out.println("=== Вариант A");

            /*
            A_AddUser.run(connection,"login1","pass1","email1@gmail.com",1);

            A_AddData.run(connection,1,5,2,"Мулявина 6","ЦА",1);
            A_AddData.run(connection,3,5,2,"Мулявина 8","не ЦА",1);
            A_AddData.run(connection,5,5,2,"Мулявина 10","не ЦА",1);
            */
            System.out.println("(пользователи и объявления добавлены ранее)");

            System.out.println("=== Вариант B");

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

