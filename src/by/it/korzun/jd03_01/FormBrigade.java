package by.it.korzun.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FormBrigade {
    public static void form(int fp, int sp, int n, int ro, int s)throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement=connection.createStatement();
        String sql = String.format("INSERT INTO `brigades` (`FirstPilotID`, `SecondPilotID`, `NavigatorID`, `Radio_operatorID`, `StewardessID`) " +
                "VALUES ('%d', '%d', '%d', '%d', '%d')", fp, sp, n, ro, s);
        statement.executeUpdate(sql);

    }
}
