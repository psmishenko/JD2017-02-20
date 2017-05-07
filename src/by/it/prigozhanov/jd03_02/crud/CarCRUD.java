package by.it.prigozhanov.jd03_02.crud;

import by.it.prigozhanov.jd03_02.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 5/1/2017.
 *
 * @author v-omf
 */
public class CarCRUD {

    public boolean create(Car car) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = String.format("INSERT INTO `cars`(`Mark`, `Model`, `HP`, `Location`, `Luggage_capacity`) VALUES ('%s','%s','%d','%s','%s')",
                    car.getMark(), car.getModel(), car.getHp(), car.getLocation(),car.getLuggageCapacity());
            if (statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS) == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int id = keys.getInt(1);
                    car.setId(id);
                    return true;
                }
            }
            return false;

        }
    }

    public Car read(Car car) throws SQLException {
        Car result = null;
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Mark`, `Model`, `HP`, `Location`, `Luggage_capacity` FROM `cars` WHERE ID=%d", car.getId());
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                result = new Car(
                        rs.getInt("ID"),
                        rs.getString("Mark"),
                        rs.getString("Model"),
                        rs.getInt("HP"),
                        rs.getString("Location"),
                        rs.getInt("Luggage_capacity")
                );
            }
        }
        return result;
    }

    public boolean update(Car car) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "UPDATE `cars` SET `Mark`='%s',`Model`='%s',`HP`='%d',`Location`='%s',`Luggage_capacity`='%d' WHERE ID=%d",
                    car.getMark(), car.getModel(), car.getHp(), car.getLocation(), car.getLuggageCapacity(), car.getId()
            );
            return (1 == statement.executeUpdate(sql));
        }
    }


    public boolean delete(Car car) throws SQLException {
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format("DELETE FROM `cars` WHERE ID = %d", car.getId());
            return (1 == statement.executeUpdate(sql));
        }
    }


}
