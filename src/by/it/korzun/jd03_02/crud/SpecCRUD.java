package by.it.korzun.jd03_02.crud;

import by.it.korzun.jd03_02.beans.Specialization;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecCRUD {
    public boolean create(Specialization spec) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()){

            String sql = String.format("INSERT INTO `Specializations`(`Specialization`) " +
                    "VALUES ('%s')", spec.getSpecialization());

            if(1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    int id = keys.getInt(1);
                    spec.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean update(Specialization spec){
        return false;
    }

    public static Specialization read(int id) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){
            Specialization res = null;

            String sql = String.format("SELECT * FROM `Specializations` WHERE ID=%d",
                    id);

            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                res = new Specialization(
                        rs.getInt("ID"),
                        rs.getString("Specialization")
                );
            }
            return res;
        }
    }

    public boolean delete(Specialization spec){
        return false;
    }
}
