package by.it.prigozhanov.project.java.dao;

import by.it.prigozhanov.project.java.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class CarDAO extends AbstractDAO implements InterfaceDAO<Car> {


    @Override
    public boolean create(Car car) throws SQLException {
        String sql = String.format("INSERT INTO `cars`(`Mark`, `Model`, `HP`, `Location`, `Luggage_capacity`, `Price`, `Seats`, `Fuel_consumption`)" +
                        " VALUES ('%s','%s','%d','%s','%s','%d','%d','%d')",
                car.getMark(), car.getModel(), car.getHp(), car.getLocation(), car.getLuggageCapacity(), car.getPrice(), car.getSeats(), car.getFuelConsumption());
        int id = executeCreate(sql);
        if (id > 0) {
            car.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public Car read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<Car> listCars = getAll(whereString);
        if (listCars.size() == 1) {
            return listCars.get(0);
        }
        return null;
    }

    @Override
    public boolean update(Car car) throws SQLException {
        String sql = String.format(
                "UPDATE `cars` SET `Mark`='%s',`Model`='%s',`HP`='%d',`Location`='%s',`Luggage_capacity`='%d', " +
                        "`Price`='%d',`Seats`='%d',`Fuel_consumption`='%d' WHERE ID=%d",
                car.getMark(), car.getModel(), car.getHp(), car.getLocation(), car.getLuggageCapacity(), car.getPrice(), car.getSeats(), car.getFuelConsumption(), car.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Car car) throws SQLException {
        String sql = String.format("DELETE FROM `cars` WHERE ID = %d",
                car.getId());
        return executeUpdate(sql);
    }

    @Override
    public List getAll(String whereString) throws SQLException {
        List<Car> carsList = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("SELECT `ID`, `Mark`, `Model`, `HP`, `Location`, `Luggage_capacity`, `Price`, `Seats`, `Fuel_consumption` FROM `cars` %s", whereString);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                carsList.add(new Car(
                                rs.getInt("ID"),
                                rs.getString("Mark"),
                                rs.getString("Model"),
                                rs.getInt("HP"),
                                rs.getString("Location"),
                                rs.getInt("Luggage_capacity"),
                                rs.getInt("Price"),
                                rs.getInt("Seats"),
                                rs.getInt("Fuel_consumption")
                        )
                );
            }


        }
        return carsList;
    }
}
