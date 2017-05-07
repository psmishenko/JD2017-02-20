package by.it.prigozhanov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/30/2017!
 */
public class A_AddUser {

    public static void add() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver couldn't load: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO users(`Passport_data`, `Login`, `Password`, `Email`) " +
                    "VALUES ('MJ239543','Petrov','12356','petrov@gmail.com')");
            System.out.println("Пользователь добавлен в базу данных");
            statement.executeUpdate("INSERT INTO users(`Passport_data`, `Login`, `Password`, `Email`,`FK_Roles`) " +
                    "VALUES ('MJ2395343','Gerasomov','12356','gerasimov@gmail.com',1)");
            System.out.println("Пользователь добавлен в базу данных");
            statement.executeUpdate("INSERT INTO users(`Passport_data`, `Login`, `Password`, `Email`, `FK_Roles`) " +
                    "VALUES ('MJ2351543','Petrov','1235213','petrov1973@gmail.com',2)");
            System.out.println("Пользователь добавлен в базу данных");
        } catch (SQLException e) {

        }


    }

}
