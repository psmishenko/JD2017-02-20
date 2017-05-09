package by.it.prigozhanov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/30/2017!
 */
public class A_AddCar {

    public static void add() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver couldn't load: " + e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO cars(`Mark`, `Model`, `HP`, `Location`, `Luggage_capacity`)" +
                    " VALUES ('Renault','Sandero',110,'Minsk',5)");
            System.out.println("Автомобиль добавлен в базу данных");
        } catch (SQLException e) {

        }


    }

}
