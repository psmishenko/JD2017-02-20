package by.it.radivonik.jd03_03;

import by.it.radivonik.jd03_03.crud.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 03.05.2017.
 */
public abstract class AbstractDAO {
    int executeUpdate(String sql) throws SQLException {
        int res = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            res = statement.executeUpdate(sql);
        }
        return res;
    }

    int executeCreate(String sql) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            if (statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next())
                     return keys.getInt(1);
            }
        }
        return -1;
    }
}
