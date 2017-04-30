package by.it.korzun.jd03_01;

import java.sql.*;

public class C_Reset {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("DROP TABLE IF EXISTS Flights ");
            statement.executeUpdate("DROP TABLE IF EXISTS Brigades ");
            statement.executeUpdate("DROP TABLE IF EXISTS Staff ");
            statement.executeUpdate("DROP TABLE IF EXISTS Specializations ");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
