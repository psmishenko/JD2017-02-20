package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class C_Reset {
    public void run() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        try {
            statement.executeUpdate("DROP TABLE `sklad`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `sostavnaklad`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `naklad`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `avto`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `klient`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `typenaklad`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `tovar`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `user`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            statement.executeUpdate("DROP TABLE `role`");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Таблицы из базы данных удалены");
    }
}
