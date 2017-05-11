package by.it.Zyryanov.jd03_02.crud;

import by.it.Zyryanov.jd03_02.beans.Orders;
import by.it.Zyryanov.jd03_02.connection.ConnectionCreator2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders_CRUD {


    public boolean create(Orders orders) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "INSERT INTO Orders(fk_Users, fk_Book) VALUES ('%d', '%d');",
                    orders.getFk_Users(),
                    orders.getFk_Books()
            );
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    orders.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public Orders read(Orders orders) throws SQLException {

        Orders result = null;

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `id`, `fk_Book`, `fk_Users` FROM `Orders` WHERE ID = %d",
                    orders.getId()
            );
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Orders(
                        rs.getInt("ID"),
                        rs.getInt("fk_Users"),
                        rs.getInt("fk_Book")
                );

            }

        }
        return result;
    }

    public boolean update(Orders orders) throws SQLException {
        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `Orders` SET `fk_Book`= %d,`fk_Users`=%d WHERE ID = %d",
                    orders.getFk_Books(),
                    orders.getFk_Users(),
                    orders.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Orders orders) throws SQLException {

        try (Connection connection = ConnectionCreator2.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "DELETE FROM Roles WHERE ID = %d",
                    orders.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }
}
