package by.it.korzun.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddSpecialization {
    public static void add(String spec)throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement=connection.createStatement();
        String sql = String.format("INSERT INTO `specializations` (`Specialization`) "
                + " VALUES ('%s')",spec);
        statement.executeUpdate(sql);
    }
}
