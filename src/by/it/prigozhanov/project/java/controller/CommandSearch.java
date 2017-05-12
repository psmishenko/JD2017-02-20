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
public class CommandSearch extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        String s = request.getParameter("search");
        List<Car> cars;
        if (s != null) {
            try {
                cars = dao.car.getAll(String.format("WHERE Mark='%s' OR Model='%s' OR Location='%s'", s, s, s));
                request.setAttribute("cars", cars);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
