package by.it.zeynalov.project.java.dao;

import by.it.zeynalov.project.java.beans.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends AbstractDAO implements InterfaceDAO<Orders>{
    public boolean create(Orders orders) throws SQLException {
        String sql = String.format(
                "INSERT INTO `orders`(`Latte`, `Americano`, `Cappuccino`, `Espresso`) " + "VALUES ('%s');",
                orders.getLatte(),
                orders.getAmericano(),
                orders.getCappuccino(),
                orders.getEspresso()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            orders.setID(id);
            return true;
        }
        return false;
    }

    public Orders read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<Orders> listOrders = getAll(whereString);
        if (listOrders.size() == 1) {
            return listOrders.get(0);
        }
        return null;
    }

    public boolean update(Orders orders) throws SQLException {
        String sql = String.format(
                "UPDATE `orders` SET " +
                        "`Latte`='%s'," +
                        "`Americano`='%d'," +
                        "`Cappuccino`='%d'," +
                        "`Espresso`='%s'," +
                        "WHERE ID=%d",
                orders.getLatte(),
                orders.getEspresso(),
                orders.getCappuccino(),
                orders.getEspresso(),
                orders.getID()
        );
        return executeUpdate(sql);
    }

    public boolean delete(Orders orders) throws SQLException {
        String sql = String.format(
                "DELETE FROM `menu` WHERE ID=%d",
                orders.getID()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Orders> getAll(String whereString) throws SQLException {
        List<Orders> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Latte`, `Americano`, `Cappuccino`, `Espresso` FROM `menu` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Orders orders = new Orders(
                        rs.getInt("ID"),
                        rs.getString("Latte"),
                        rs.getString("Americano"),
                        rs.getString("Cappuccino"),
                        rs.getString("Espresso")
                );
                result.add(orders);
            }
        }
        return result;
    }
}
