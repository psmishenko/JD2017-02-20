package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.beans.Order;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        List<Order> orders;


        try {
            cars = dao.car.getAll("");
            request.setAttribute("cars", cars);

            if (request.getParameter("id") != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", request.getParameter("id"));
                orders = dao.order.getAll("WHERE FK_Cars="+request.getParameter("id"));
                request.setAttribute("orders", orders);

                if (orders.size() >= 1) {
                    return Actions.CARS.command;
                }
                   return Actions.RENTCAR.command;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.CARS.command;
    }
}
