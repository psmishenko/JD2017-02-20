package by.it.Zyryanov.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by georgijzyranov on 11.05.17.
 */
public class C_Reset {
    public static void reset() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS testDB.orders");
            statement.executeUpdate("DROP TABLE IF EXISTS testDB.books");
            statement.executeUpdate("DROP TABLE IF EXISTS testDB.users");
            statement.executeUpdate("DROP TABLE IF EXISTS testDB.roles");


            System.out.println("Вcе таблицы успешно удалены");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
