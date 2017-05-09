package by.it.psmishenko.jd03_1;

import java.sql.*;

/**
 * Created by GN on 01.05.2017.
 */
public class ResetTables {
    static void resetAllDB() throws SQLException {
        String sql = "DROP TABLE IF EXISTS `books`;";
        String sql2 = "DROP TABLE IF EXISTS `users`;";
        String sql3 = "DROP TABLE IF EXISTS `roles`;";
        Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
    }
}
