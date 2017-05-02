package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.crud.ConnectorCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class C_RunSQL {

    public static void run(String SQL) throws SQLException {

        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ) {
            statement.executeUpdate(SQL);
        }
    }

}
