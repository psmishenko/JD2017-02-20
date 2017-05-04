package by.it.korzun.jd03_02.crud;

import by.it.korzun.jd03_02.beans.Brigade;
import by.it.korzun.jd03_02.beans.Staff;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BrigadeCRUD {
    public boolean create(Brigade brigade) throws SQLException {
        try(Connection connection = ConnectionCreator.getConnection();
            Statement statement = connection.createStatement()){
            String sql = String.format("INSERT INTO `Brigades`(`FirstPilotID`,`SecondPilotID`,`NavigatorID`,`Radio-operatorID`,`StewardessID`) " +
                    "VALUES('%d','%d','%d','%d','%d')",
                    brigade.getFirstPilotID(),
                    brigade.getSecondPilotID(),
                    brigade.getNavigatorID(),
                    brigade.getRadio_operatorID(),
                    brigade.getStewardessID()
            );

            if(1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet keys = statement.getGeneratedKeys();
                if(keys.next()){
                    int id = keys.getInt(1);
                    brigade.setId(id);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean update(Staff staff) throws SQLException {
        return false;
    }

    public Brigade read(int id) throws SQLException {
        Brigade res = null;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT * FROM `Brigades` WHERE ID=%d",
                    id);

            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                res = new Brigade(
                        rs.getInt("ID"),
                        rs.getInt("FirstPilotID"),
                        rs.getInt("SecondPilotID"),
                        rs.getInt("NavigatorID"),
                        rs.getInt("Radio_operatorID"),
                        rs.getInt("StewardessID")

                );
            }
            return res;
        }
    }

    public boolean delete(Brigade bigade)throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `BrigadeS` WHERE ID = %d", bigade.getId());

            return (1 == statement.executeUpdate(sql));
        }
    }
}
