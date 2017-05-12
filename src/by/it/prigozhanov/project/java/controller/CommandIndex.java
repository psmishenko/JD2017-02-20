package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/12/2017!
 */
public class CommandIndex extends Action {
    @Override
    Action execute(HttpServletRequest request) {

        DAO dao = DAO.getInstance();
        try {
            List<Car> cars = dao.car.getAll("");
            request.setAttribute("cars", cars);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR, e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
