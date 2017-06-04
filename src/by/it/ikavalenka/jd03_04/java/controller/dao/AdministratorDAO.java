package by.it.ikavalenka.jd03_04.java.controller.dao;
import by.it.ikavalenka.jd03_04.java.controller.dao.AbstractDAO;
import by.it.ikavalenka.jd03_04.java.controller.dao.Connect;
import by.it.ikavalenka.jd03_04.java.controller.dao.IDAO;
import by.it.ikavalenka.jd03_04.java.controller.dao.beans.administrator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 14.05.2017.
 */
public class AdministratorDAO  extends AbstractDAO implements IDAO<administrator>{
    @Override
    public boolean create(administrator administrator) throws SQLException{
        String sql = String.format("INSERT INTO 'administrator'('Login ', 'Password ', 'Catalog ', 'FullOrder_id ', 'BlackList_id_fk ')" +
                "VALUES ('%s','%s','%d','%s','%s');",administrator.getLogin(), administrator.getPassword(), administrator.getCatalog(), administrator.getFullOrder_id(), administrator.getBlackList_id_fk());
        int id = executeCreate(sql);
        if (id > 0){
            administrator.setAdm_id(id);
            return true;
        }
        return false;
    }
    @Override
    public administrator read(int id) throws SQLException{
        String whereString = String.format("WHERE Adm_id=%d", id);
        List<administrator> administratorList = getAll(whereString);
        if (administratorList.size()==1){
            return administratorList.get(0);
        }
        return null;
    }
    @Override
    public int update(administrator administrator) throws SQLException{
        String sql = String.format("UPDATE 'administrator' SET " +
                "'Login'='%s'," +
                "'Password'= '%s',"+
                "'Catalog' = '%d',"+
                "'FullOrder_id' = '%s'"+
                "'BlackList_id_fk' = '%s'" +
                "WHERE Adm_id=%d",
                administrator.getLogin(),administrator.getPassword(),administrator.getCatalog(),administrator.getFullOrder_id(),administrator.getBlackList_id_fk()
        );
        return executeUpdate(sql);
    }
    @Override
    public int delete(administrator administrator) throws SQLException{
        String sql =String.format("DELETE FROM 'administrator' WHERE Adm_id=%d",
                administrator.getAdm_id());
            return executeUpdate(sql);
    }

    @Override
    public List<administrator> getAll(String whereString) throws SQLException {
        List<administrator> result = new ArrayList<>();
        try (Connection connection = Connect.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT 'Adm_id', 'Login', 'Password', 'Catalog', 'FullOrder_id', 'BlackList_id_fk' FROM 'administrator' %s;",
                    whereString);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                administrator administrator = new administrator(
                        resultSet.getInt("Adm_id"),
                        resultSet.getInt("Login"),
                        resultSet.getInt("Password"),
                        resultSet.getString("Catalog"),
                        resultSet.getInt("FullOrder_id"),
                        resultSet.getInt("BlackList_id_fk"));
                result.add(administrator);

            }

        }
        return result;
    }
    }



