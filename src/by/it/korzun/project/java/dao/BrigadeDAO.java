package by.it.korzun.project.java.dao;

import by.it.korzun.project.java.beans.Brigade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BrigadeDAO extends AbstractDAO implements InterfaceDAO<Brigade>{
    public boolean create(Brigade brigade) throws SQLException {
        String sql = String.format("INSERT INTO `Brigades`(`FirstPilotID`,`SecondPilotID`,`NavigatorID`,`Radio_operatorID`,`StewardessID`) " +
                "VALUES('%d','%d','%d','%d','%d')",
                brigade.getFirstPilotID(),
                brigade.getSecondPilotID(),
                brigade.getNavigatorID(),
                brigade.getRadio_operatorID(),
                brigade.getStewardessID()
        );

        int id = executeCreate(sql);
        if(id > 0){
            brigade.setId(id);
            return true;
        }
        return false;
    }

    public boolean update(Brigade brigade)throws SQLException {
        String sql = String.format("UPDATE `Brigades` SET "+
                        "`firstpilotid` = '%d', " +
                        "`secondpilotid` = '%d', " +
                        "`navigatorid` = '%d', " +
                        "`radio_operatorid` = '%d', " +
                        "`stewardessid` = '%d' " +
                        "WHERE ID = %d",
                brigade.getFirstPilotID(),
                brigade.getSecondPilotID(),
                brigade.getNavigatorID(),
                brigade.getRadio_operatorID(),
                brigade.getStewardessID(),
                brigade.getId()
        );
        return executeUpdate(sql);
    }

    public Brigade read(int id)throws SQLException{
        List<Brigade> list = getAll("WHERE ID = " + id + " LIMIT 0,1");
        if(list.size() > 0){
            return list.get(0);
        }else
            return null;
    }

    public boolean delete(Brigade brigade)throws SQLException {
        String sql = String.format("DELETE FROM `Brigades` WHERE ID = %d", brigade.getId());

        return executeUpdate(sql);
    }

    @Override
    public List<Brigade> getAll(String whereString){
        List<Brigade> res = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `Brigades` " + whereString + " ;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Brigade brigade = new Brigade();
                brigade.setId(rs.getInt("ID"));
                brigade.setFirstPilotID(rs.getInt("FirstPilotID"));
                brigade.setSecondPilotID(rs.getInt("SecondPilotID"));
                brigade.setNavigatorID(rs.getInt("NavigatorID"));
                brigade.setRadio_operatorID(rs.getInt("Radio_operatorID"));
                brigade.setStewardessID(rs.getInt("StewardessID"));
                res.add(brigade);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
