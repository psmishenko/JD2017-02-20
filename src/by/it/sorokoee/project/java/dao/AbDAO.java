package by.it.sorokoee.project.java.dao;

import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbDAO {
    protected int executeUpdate(String sql) {
        int result = -1;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql);
            if (sql.trim().toUpperCase().startsWith("INSERT")) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) result = resultSet.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }


}
