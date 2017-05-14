package by.it.ikavalenka.jd03_02.CRUD;
import by.it.ikavalenka.jd03_02.beans.blacklist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

/**
 * Created by USER on 12.05.2017.
 */
public class BlackListCRUD {
 public boolean create (blacklist blacklist) throws SQLException {
     try (Connection connection = Connect.getConnection();
          Statement statement = connection.createStatement()){
         String sql = String.format("INSERT INTO 'blacklist'(Black_list_ID,Client_id_fk)" + "VALUES ('%s','%s')");
        if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()){
                int id = keys.getInt(1);
                blacklist.setBlack_list_ID(id);
                return  true;
            }
        }
        return false;
     }
 }
 public blacklist read(blacklist blacklist) throws SQLException{
     blacklist blacklistResult = null;
     String readBLSQL = "SELECT * FROM blacklist WHERE Black_list_ID=" + blacklist;
     try (
             Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement();
             ){
         final  ResultSet resultSet = statement.executeQuery(readBLSQL);
         if (resultSet.next()){
             blacklistResult = new blacklist(
                     resultSet.getInt("Black_list_ID"),
                     resultSet.getInt("Client_id_fk"));
         }
     } catch (SQLException e){
                 e.printStackTrace();
     }
     return  blacklistResult;
 }
 public boolean update (blacklist blacklist) throws SQLException {
     try (
             Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
         String updateBLSQL = String.format(
                 "UPDATE blacklist SET" + "Client_id_fk='%s'" + "WHERE Black_list_ID ='%d'"
                         + blacklist.getBlack_list_ID(), blacklist.getClient_id_fk());
         return (1 == statement.executeUpdate(updateBLSQL)) ;
     }
 }
  public boolean delete (blacklist blacklist) throws SQLException{
     String deleteBLSQL = String.format("DELETE FROM blacklist WHERE Black_list_ID='%s'" ,blacklist.getBlack_list_ID());
    try (Connection connection = Connect.getConnection();
        Statement statement = connection.createStatement();
        ){
        return (statement.executeUpdate(deleteBLSQL) ==1);
    } catch (SQLException e){
            throw e;
    }
 }
}
