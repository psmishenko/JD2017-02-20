package by.it.korzun.project.java.dao;

import by.it.korzun.project.java.beans.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO extends AbstractDAO implements InterfaceDAO<Staff>{
    public boolean create(Staff staff) throws SQLException {
        String sql = String.format("INSERT INTO `Staff`(`Name`,`Login`,`Password`,`FK_Specialization`) " +
                "VALUES('%s','%s','%s','%d')",
                staff.getName(),
                staff.getLogin(),
                staff.getPassword(),
                staff.getFk_specialization());

        int id = executeCreate(sql);
        if(id > 0) {
            staff.setId(id);
            return true;
        }
        return false;
    }

    public boolean update(Staff staff) throws SQLException {
            String sql = String.format("UPDATE `Staff` SET "+
                            "`Name` = '%s', " +
                            "`Login` = '%s', " +
                            "`Password` = '%s', " +
                            "`FK_Specialization` = '%d' " +
                            "WHERE ID = %d",
                    staff.getLogin(),
                    staff.getPassword(),
                    staff.getName(),
                    staff.getFk_specialization(),
                    staff.getId()
            );
            return executeUpdate(sql);
    }

    public Staff read(int id) throws SQLException {
        List<Staff> list = getAll("WHERE ID = " + id + " LIMIT 0,1");
        if(list.size() > 0){
            return list.get(0);
        }else
            return null;
    }

    public boolean delete(Staff staff)throws SQLException {
        String sql = String.format("DELETE FROM `Staff` WHERE ID = %d", staff.getId());

        return executeUpdate(sql);
    }

    @Override
    public List<Staff> getAll(String whereString){
        List<Staff> res = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `Staff` " + whereString + " ;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getInt("ID"));
                staff.setName(rs.getString("Name"));
                staff.setLogin(rs.getString("Login"));
                staff.setPassword(rs.getString("Password"));
                staff.setFk_specialization(rs.getInt("FK_specialization"));
                res.add(staff);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
