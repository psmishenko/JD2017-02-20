package by.it.radivonik.jd03_02.dbadmin;

import by.it.radivonik.jd03_02.connection.ConnectionCreator;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class DBReset {
    public static void exec() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        statement.executeUpdate("DROP TABLE IF EXISTS `sklad`");
        statement.executeUpdate("DROP TABLE IF EXISTS `sostavnaklad`");
        statement.executeUpdate("DROP TABLE IF EXISTS `naklad`");
        statement.executeUpdate("DROP TABLE IF EXISTS `avto`");
        statement.executeUpdate("DROP TABLE IF EXISTS `klient`");
        statement.executeUpdate("DROP TABLE IF EXISTS `typenaklad`");
        statement.executeUpdate("DROP TABLE IF EXISTS `tovar`");
        statement.executeUpdate("DROP TABLE IF EXISTS `user`");
        statement.executeUpdate("DROP TABLE IF EXISTS `role`");
        System.out.println("Таблицы из базы данных удалены");
    }
}
