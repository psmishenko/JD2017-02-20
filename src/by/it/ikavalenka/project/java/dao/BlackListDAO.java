package by.it.ikavalenka.project.java.dao;
import by.it.ikavalenka.project.java.connection.ConnectionCreator;
import by.it.ikavalenka.project.java.dao.IDAO;
import by.it.ikavalenka.project.java.beans.blacklist;
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
public class BlackListDAO extends AbstractDAO implements IDAO<blacklist> {
    @Override
    public boolean create(blacklist blacklist) throws SQLException {
        String sql = String.format("INSERT INTO 'blacklist'('Client_id_fk')" +
                "VALUES ('%s');", blacklist.getClient_id_fk());
        int id = executeCreate(sql);
        if (id > 0){
            blacklist.setBlack_list_ID(id);
            return true;
        }
        return false;
    }
    @Override
    public blacklist read(int id) throws SQLException{
        String whereString = String.format("WHERE Client_id_fk=%d", id);
        List<blacklist> blacklistList = getAll(whereString);
        if (blacklistList.size()==1){
            return blacklistList.get(0);
        }
        return null;
    }
    @Override
    public int update(blacklist blacklist) throws SQLException{
        String sql = String.format("UPDATE 'blacklist' SET " +
                        "'Client_id_fk'='%s'"+
                        "WHERE Black_list_ID",
                blacklist.getClient_id_fk());
        return executeUpdate(sql);
    }
    @Override
    public int delete(blacklist blacklist) throws SQLException{
        String sql =String.format("DELETE FROM 'blacklist' WHERE Client_id_fk=%d",
                blacklist.getBlack_list_ID());
        return executeUpdate(sql);
    }
    @Override
    public List<blacklist> getAll(String whereString) throws SQLException {
        List<blacklist> result = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT 'Client_id_fk', 'Black_list_ID' FROM 'blacklist' %s;",
                    whereString);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                blacklist blacklist = new blacklist(
                        resultSet.getInt("Adm_id"),
                        resultSet.getInt("Client_id_fk"));
                result.add(blacklist);

            }

        }
        return result;
    }
}
