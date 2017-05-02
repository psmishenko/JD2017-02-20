package by.it.loktev.jd03_01;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_RunSQL {

    public static void run(Connection connection, String SQL) throws SQLException {

            Statement statement=connection.createStatement();
            statement.executeUpdate(SQL);
    }

}
