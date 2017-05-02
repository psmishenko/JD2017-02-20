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

            System.out.println("\n=== Вариант A\n");
/*
            A_AddUser.run(connection,"login1","pass1","email1@gmail.com",1);

            A_AddData.run(connection,1,5,2,"Мулявина 6","ЦА",1);
            A_AddData.run(connection,3,5,2,"Мулявина 8","не ЦА",1);
            A_AddData.run(connection,5,5,2,"Мулявина 10","не ЦА",1);

            //System.out.println("(пользователи и объявления добавлены ранее)");
*/
            System.out.println("\n=== Вариант B\n");

//            B_ShowUsers.run(connection);

            System.out.println("\n=== Вариант C\n");

            C_Reset.run(connection);
            System.out.println("База очищена!");

            C_Init.run(connection);
            System.out.println("База наполнена!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

