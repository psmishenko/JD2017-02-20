package by.it.psmishenko.jd03_2.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 01.05.2017.
 */
public class ResetTables {
    public static void resetAllDB() throws SQLException {
        String sql = "DROP TABLE IF EXISTS `books`;";
        String sql2 = "DROP TABLE IF EXISTS `users`;";
        String sql3 = "DROP TABLE IF EXISTS `roles`;";
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            System.out.println("Таблицы удалены");
        }
    }
}
