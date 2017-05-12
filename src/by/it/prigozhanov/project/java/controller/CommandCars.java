package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/11/2017.
 *
 * @author v-omf
 */
public class CommandCars extends Action{
    @Override
    Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        List<Car> cars;
        try {
            cars = dao.car.getAll("");
            request.setAttribute("cars", cars);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.CARS.command;
    }
}
