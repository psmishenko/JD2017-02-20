package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.beans.Order;
import by.it.prigozhanov.project.java.dao.DAO;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
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
            if (Form.isPost(request)) {
                if (request.getParameter("Update") != null) {
                    Order order = new Order(
                            Form.getInt(request, "id"),
                            Form.getString(request, "passportdata", Pattern.PASSPORT),
                            Form.getString(request, "cardnumber", Pattern.CARDNUMBER),
                            Form.getInt(request, "orderduration"),
                            Form.getString(request, "telephone", Pattern.TELEPHONE),
                            Form.getInt(request, "fk_users"),
                            Form.getInt(request, "fk_cars")

                    );
                    dao.order.update(order);
                }
                if (request.getParameter("Delete") != null) {
                    Order order = new Order();
                    order.setId(Form.getInt(request, "id"));
                    dao.order.delete(order);
                }

            }
            List<Order> orders = dao.order.getAll("");
            List<Car> cars = dao.car.getAll("");
            request.setAttribute("orders", orders);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
