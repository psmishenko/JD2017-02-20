package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.beans.Order;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by v-omf on 5/11/2017.
 *
 * @author v-omf
 */
public class CommandAdvancedSearch extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        String s = request.getParameter("search");
        List<Car> cars;
        List<Order> orders;
        if (s != null) {
            try {
                cars = dao.car.getAll(String.format("WHERE Mark='%s' OR Model='%s' OR Location='%s'", s, s, s));
                if (cars.size()==0) {
                    request.setAttribute(Messages.MSG_MESSAGE, "Ничего не найдено");
                }
                request.setAttribute("cars", cars);
                if (request.getParameter("id") != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", request.getParameter("id"));
                    orders = dao.order.getAll("WHERE FK_Cars="+request.getParameter("id"));
                    request.setAttribute("orders", orders);

                    if (orders.size() >= 1) {
                        request.setAttribute(Messages.MSG_MESSAGE, "Этот автомобиль забронирован, выберите другой");
                        return null;
                    }
                    return Actions.RENTCAR.command;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
