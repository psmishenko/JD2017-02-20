package by.it.prigozhanov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class C_Reset {

    public static void reset() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
//            statement.executeUpdate("DROP SCHEMA IF EXISTS `prigozhanov` ;");
//            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `prigozhanov` DEFAULT CHARACTER SET utf8 ;");
            // удаление таблиц (удаление и создание схемы почему то не работает
            statement.executeUpdate("DROP TABLE IF EXISTS `prigozhanov`.`users` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `prigozhanov`.`cars` ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `prigozhanov`.`roles` ;");
            System.out.println("все таблицы удалены");

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
