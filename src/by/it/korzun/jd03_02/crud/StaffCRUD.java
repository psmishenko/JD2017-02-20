package by.it.korzun.jd03_02.crud;

import by.it.korzun.jd03_02.beans.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffCRUD {
    public boolean create(Staff staff) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement()){
            String sql = String.format("INSERT INTO `Staff`(`Name`,`FK_Specialization`) " +
                    "VALUES('%s','%d')", staff.getName(), staff.getFk_specialization());

            if(1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    int id = keys.getInt(1);
                    staff.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean update(Staff staff) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("UPDATE `Staff` SET "+
                            "`Name` = '%s', " +
                            "`FK_Specialization` = '%d' " +
                            "WHERE ID = %d",
                    staff.getName(),
                    staff.getFk_specialization(),
                    staff.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }

    public static Staff read(int id) throws SQLException {
        Staff res = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Name`, `FK_specialization` FROM `Staff` WHERE ID=%d",
                    id);

            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                res = new Staff(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getInt("FK_specialization")
                );
            }
            return res;
        }
    }

    public boolean delete(Staff staff)throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `Staff` WHERE ID = %d", staff.getId());

            return (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
        }
    }
}
