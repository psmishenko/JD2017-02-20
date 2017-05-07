package by.it.prigozhanov.project.java.dao;

import by.it.prigozhanov.project.java.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 5/6/2017!
 */
public class OrderDAO extends AbstractDAO implements InterfaceDAO<Order> {


    @Override
    public boolean create(Order order) throws SQLException {
        String sql = String.format("INSERT INTO `orders`(`Passport_data`, `Card_number`, `Order_duration`, `Telephone`, `FK_Users`, `FK_Cars`) " +
                        "VALUES ('%s','%s','%d','%s',%d,%d)",
                order.getPassportData(),
                order.getCardNumber(),
                order.getOrderDuration(),
                order.getTelephone(),
                order.getFk_Users(),
                order.getFk_Cars());
        order.setId(executeCreate(sql));
        return (order.getId() > 0);
    }

    @Override
    public Order read(int id) throws SQLException {
        List<Order> orders = getAll("WHERE ID=" + id);
        if (orders.size() > 0) {
            return orders.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean update(Order order) throws SQLException {
        String sql = String.format("UPDATE `orders` SET " +
                        "`Passport_data`='%s', " +
                        "`Card_number`='%s', " +
                        "`Order_duration`='%d'," +
                        "`Telephone`='%s'," +
                        "`FK_Users`='%d'," +
                        "`FK_Cars`='%d' WHERE ID=%d",
                order.getPassportData(),
                order.getCardNumber(),
                order.getOrderDuration(),
                order.getTelephone(),
                order.getFk_Users(),
                order.getFk_Cars(),
                order.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Order order) throws SQLException {
        String sql = String.format("DELETE FROM `orders` WHERE ID=%d", order.getId());
        return executeUpdate(sql);
    }

    @Override
    public List<Order> getAll(String whereString) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM `orders`" + whereString;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("ID"),
                        rs.getString("Passport_data"),
                        rs.getString("Card_number"),
                        rs.getInt("Order_duration"),
                        rs.getString("Telephone"),
                        rs.getInt("FK_Users"),
                        rs.getInt("FK_Cars")
                ));
            }
        }
        return orders;
    }
}
