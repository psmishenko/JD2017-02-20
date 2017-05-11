package by.it.korzun.project.java.dao;

import by.it.korzun.project.java.beans.Flight;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends AbstractDAO implements InterfaceDAO<Flight>{
    public boolean create(Flight flight) throws SQLException {
        String sql = String.format("INSERT INTO `Flights`(`Destination`, `Brigades_ID`) " +
                        "VALUES('%s','%d')",
                flight.getDestination(),
                flight.getBrigadeID()
        );

        int id = executeCreate(sql);
        if(id > 0){
            flight.setId(id);
            return true;
        }
        return false;
    }

    public boolean update(Flight flight){
        return false;
    }

    public Flight read(int id)throws SQLException{
        List<Flight> list = getAll("WHERE ID = " + id + " LIMIT 0,1");
        if(list.size() > 0){
            return list.get(0);
        }else
            return null;
    }

    public boolean delete(Flight flight)throws SQLException {
        String sql = String.format("DELETE FROM `Flights` WHERE ID = %d", flight.getId());

        return executeUpdate(sql);
    }

    @Override
    public List<Flight> getAll(String whereString){
        List<Flight> res = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM `Flights` " + whereString + " ;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt("ID"));
                flight.setDestination(rs.getString("Destination"));
                flight.setBrigadeID(rs.getInt("Brigades_ID"));
                res.add(flight);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
