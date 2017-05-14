package by.it.ikavalenka.jd03_02.CRUD;
import by.it.ikavalenka.jd03_02.beans.administrator;
import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by USER on 10.05.2017.
 */
public class RoleCRUD {
    public boolean create (administrator administrator) throws SQLException{
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()){
                 String sql = String.format("INSERT INTO 'administrator'('Login ', 'Password ', 'Catalog ', 'FullOrder_id ', 'BlackList_id_fk ')" +
                         "VALUES ('%s','%s','%d','%s','%s');",administrator.getLogin(), administrator.getPassword(), administrator.getCatalog(), administrator.getFullOrder_id(), administrator.getBlackList_id_fk());

                 if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                     ResultSet keys = statement.getGeneratedKeys();
                     if (keys.next()){
                         int id = keys.getInt(1);
                         administrator.setAdm_id(id);
                         return true;
                     }
                 }
                 return false;
        }
    }
        public administrator read(administrator administrator) throws SQLException{
         administrator administratorResult = null;
         String readUserSQL = "SELECT * FROM administrator WHERE Adm_id="+ administrator;
         try (
                 Connection connection = Connect.getConnection();
                 Statement statement = connection.createStatement();
                 ){
             final  ResultSet resultSet = statement.executeQuery(readUserSQL);
             if (resultSet.next()){
                 administratorResult = new administrator(
                         resultSet.getInt("Adm_id"),
                         resultSet.getInt("Login"),
                         resultSet.getInt("Password"),
                         resultSet.getString("Catalog"),
                         resultSet.getInt("FullOrder_id"),
                         resultSet.getInt("BlackList_id_fk"));
             }
         } catch (SQLException e){
                     e.printStackTrace();
         }
return administratorResult;

        }
     public boolean update(administrator administrator) throws SQLException{


      try (
              Connection connection = Connect.getConnection();
              Statement statement = connection.createStatement()
              ){
          String updateUserSQL = String.format(
                  "UPDATE administrator SET"+ "Login ='%s',"+"Password ='%s',"+"Catalog ='%d',"+"FullOrder_id ='%s',"+"BlackList_id_fk ='%s'"+"WHERE Adm_id=%d"
                          + administrator.getLogin(), administrator.getPassword(),administrator.getCatalog(),administrator.getFullOrder_id(),administrator.getBlackList_id_fk()
          );
           return (1 == statement.executeUpdate(updateUserSQL));
      }

     }
     public boolean delete (administrator administrator) throws SQLException{
       String deleteUserSQL = String.format("DELETE FROM administrator WHERE Adm_id ='%s'" , administrator.getAdm_id());
       try(Connection connection = Connect.getConnection();
       Statement statement = connection.createStatement();
       ){
           return (statement.executeUpdate(deleteUserSQL) ==1);
       } catch (SQLException e){
           throw e;
       }
    }
    }

