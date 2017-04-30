package by.it.korzun.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddStaff {
    public static void add(String name, int spec)throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement=connection.createStatement();
        String sql = String.format("INSERT INTO `staff` (`Name`, `FK_Specialization`) " +
                "VALUES ('%s', '%d')", name, spec);
        statement.executeUpdate(sql);

    }
}
