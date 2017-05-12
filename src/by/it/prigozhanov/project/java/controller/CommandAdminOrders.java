package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.beans.Order;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/12/2017.
 *
 * @author v-omf
 */
public class CommandAdminOrders extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            List<Order> orders = dao.order.getAll("");
            List<Car> cars = dao.car.getAll("");
            request.setAttribute("orders", orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
