package by.it.Zyryanov.jd03_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by georgijzyranov on 11.05.17.
 */
public class dbDropper {
    public static void drop() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB2, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS testDB");
            System.out.println("БД успешно удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
