package by.it.ikavalenka.project.java.dao;

import by.it.ikavalenka.project.java.connection.ConnectionCreator;
import by.it.ikavalenka.project.java.dao.IDAO;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 14.05.2017.
 */
public class ClientDAO extends AbstractDAO implements IDAO<client> {
    @Override
    public boolean create(client client) throws SQLException {
        String sql = String.format("INSERT INTO 'client'('Login ', 'Password ', 'order_ID ', 'cost_order ')" +
                "VALUES ('%s','%s','%d','%s','%s');", client.getLogin(), client.getPassword(), client.getOrder_ID(), client.getCost_order());
        int id = executeCreate(sql);
        if (id > 0) {
            client.setClient_ID(id);
            return true;
        }
        return false;
    }

    @Override
    public client read(int id) throws SQLException {
        String whereString = String.format("WHERE Client_ID=%d", id);
        List<client> clientList = getAll(whereString);
        if (clientList.size() == 1) {
            return clientList.get(0);
        }
        return null;
    }

    @Override
    public int update(client client) throws SQLException {
        String sql = String.format("UPDATE 'client' SET " +
                        "'Login'='%s'," +
                        "'Password'= '%s'," +
                        "'order_ID' = '%s'," +
                        "'cost_order' = '%d'" +
                        "WHERE Client_ID=%d",
                client.getLogin(), client.getPassword(), client.getOrder_ID(), client.getCost_order()
        );
        return executeUpdate(sql);
    }

    @Override
    public int delete(client client) throws SQLException {
        String sql = String.format("DELETE FROM 'client' WHERE Client_ID=%d",
                client.getClient_ID());
        return executeUpdate(sql);
    }

    @Override
    public List<client> getAll(String whereString) throws SQLException {
        List<client> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT 'Client_ID', 'Login', 'Password', 'order_ID', 'cost_order' FROM 'client' %s;",
                    whereString);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                client client = new client(
                        resultSet.getInt("Client_ID"),
                        resultSet.getInt("Login"),
                        resultSet.getInt("Password"),
                        resultSet.getInt("order_ID"),
                        resultSet.getString("cost_order"));

                result.add(client);

            }
        } return result;
    }
}
