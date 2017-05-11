package by.it.Zyryanov.jd03_03.dao;


import by.it.Zyryanov.jd03_03.beans.Orders;
import by.it.Zyryanov.jd03_03.connection.ConnectionCreator;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Orders_DAO extends AbstractDAO implements interfaceDAO<Orders> {


    @Override
    public List<Orders> getAll(String WHERE) {
        List<Orders> orders = new ArrayList<>();

        String sql = "SELECT * FROM orders " + WHERE + ";";

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt("ID"));
                order.setFk_Books(rs.getInt("Books"));
                order.setFk_Users(rs.getInt("Users"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }


    @Override
    public Orders read(int id) {
        List<Orders> orders = getAll("WHERE ID = " + id + "Limit 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean create(Orders order) {
        String sql = String.format(
                "INSERT INTO Orders(fk_Users, fk_Books) VALUES ('%d', '%d');",
                order.getFk_Users(),
                order.getFk_Books()
        );
        order.setId(executeUpdate(sql));
        return (order.getId() > 0);
    }

    @Override
    public boolean update(Orders order) {
        String sql = String.format(
                "UPDATE `Orders` SET `fk_Book`= %d,`fk_Users`=%d WHERE ID = %d",
                order.getFk_Books(),
                order.getFk_Users(),
                order.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Orders order) {
        String sql = String.format(
                "DELETE FROM Roles WHERE ID = %d",
                order.getId()
        );
        return (0 < executeUpdate(sql));
    }
}
