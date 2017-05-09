package by.it.ikavalenka.jd03_01.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Created by USER on 03.05.2017.
 */
public class DropDB {
    public static void main(String[] args){
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table blacklist;");
            statement.executeUpdate("drop table administrator;");
            statement.executeUpdate("drop table client;");
            statement.executeUpdate("drop table roles;");
            System.out.println("All tables were deleted");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
