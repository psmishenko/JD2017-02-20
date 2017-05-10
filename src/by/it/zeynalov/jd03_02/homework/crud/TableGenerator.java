package by.it.zeynalov.jd03_02.homework.crud;



import by.it.zeynalov.jd03_02.homework.beans.Role;
import by.it.zeynalov.jd03_02.homework.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TableGenerator {
    public void dropAllTables() throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "DROP TABLE IF EXISTS users, roles, menu, orders;";
            statement.executeUpdate(sql);
        }
    }

    public void createAllTables() throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "";
            sql = "CREATE TABLE menu (\n" +
                    "    id      INTEGER  PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    title   VARCHAR (50),\n" +
                    "    price   INTEGER (100),\n" +
                    "    recept  VARCHAR (500))";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE roles (\n" +
                    "    id      INTEGER  PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    title   VARCHAR (50))\n";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE users (\n" +
                    "    id         INTEGER  PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    login      VARCHAR (50),\n" +
                    "    password   VARCHAR (100),\n" +
                    "    email      VARCHAR (500),\n" +
                    "    fc_rolles  INTEGER (11))";
            statement.executeUpdate(sql);
        }
    }

    public void prepareData() throws SQLException{
        UserCRUD uc = new UserCRUD();
        RoleCRUD rc = new RoleCRUD();
        rc.create(new Role(1, "Официнат"));
        rc.create(new Role(2, "Manager"));
        uc.create(new User(1, "admin", "qwerty", "55555@mail.ru", 1));
        uc.create(new User(2, "admin", "qwerty", "55555@mail.ru", 2));
    }
}
