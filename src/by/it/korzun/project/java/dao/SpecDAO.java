package by.it.korzun.project.java.dao;

import by.it.korzun.project.java.beans.Specialization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecDAO extends AbstractDAO implements InterfaceDAO<Specialization>{
    public boolean create(Specialization spec) throws SQLException {

        String sql = String.format("INSERT INTO `Specializations`(`Specialization`) " +
                "VALUES ('%s')", spec.getSpecialization());

        int id = executeCreate(sql);
        if(id > 0) {
            spec.setId(id);
            return true;
        }
        return false;
    }

    public boolean update(Specialization spec){
        return false;
    }

    public Specialization read(int id) throws SQLException {
        List<Specialization> res = getAll("WHERE ID = " + id + " LIMIT 0,1");
        if(res.size() > 0){
            return res.get(0);
        }else
            return null;
    }

    public boolean delete(Specialization spec){
        return false;
    }

    @Override
    public List<Specialization> getAll(String whereString){
        List<Specialization> res = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `Specializations` " + whereString + " ;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Specialization spec = new Specialization();
                spec.setId(rs.getInt("ID"));
                spec.setSpecialization(rs.getString("Specialization"));
                res.add(spec);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


