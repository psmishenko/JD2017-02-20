package by.it.ikavalenka.jd03_02.CRUD;
import by.it.ikavalenka.jd03_02.beans.client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by USER on 12.05.2017.
 */
public class ClientCRUD {
    public boolean create(client client) throws SQLException {
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("INSERT INTO 'clent'(Login, Password, order_ID, cost_order)" +
                    "VALUES(432,123,123,OrdeeCl)", client.getClient_ID());
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    client.setClient_ID(id);
                    return true;
                }
            }
            return false;
        }
    }

    public client read(client client) throws SQLException {
        client clientResult = null;
        String readClientSQL = "SELECT * FROM client WHERE Client_ID=" + client;
        try (
                Connection connection = Connect.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readClientSQL);
            if (resultSet.next()) {
                clientResult = new client(
                        resultSet.getInt("Client_ID"),
                        resultSet.getInt("Login"),
                        resultSet.getInt("Password"),
                        resultSet.getInt("order_ID"),
                        resultSet.getString("cost_order"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientResult;
    }
    public  boolean update(client client) throws  SQLException{


        try (
                Connection connection = Connect.getConnection();
                Statement statement = connection.createStatement())
        {String updateClientSQL = String.format("UPDATE client SET" +"Login = '%s',"+"Password ='%s',"+"order_ID = '%s',"+"cost_order= '%d'"+"WHERE Client_ID=%d"
                + client.getLogin(), client.getPassword(), client.getOrder_ID(), client.getCost_order());
            return (1==statement.executeUpdate(updateClientSQL));
        }
        }

    public boolean delete (client client) throws SQLException{
        String deleteClientSQL = String.format("DELETE FROM client WHERE Client_ID='%s'", client.getClient_ID());
        try( Connection connection = Connect.getConnection();
            Statement statement  = connection.createStatement();
        ){
            return (statement.executeUpdate(deleteClientSQL) == 1);
        }catch (SQLException e){
            throw e;
            }
        }
    }

