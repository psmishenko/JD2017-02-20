package by.it.prigozhanov.project.java.controller;


import by.it.prigozhanov.project.java.beans.Order;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by v-omf on 5/7/2017.
 *
 * @author v-omf
 */
public class CommandRentCar extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            Order order = new Order();
            DAO dao = DAO.getInstance();
            try {
                HttpSession session = request.getSession();
                if (Utils.getSessionUser(request) != null) {
                    order.setCardNumber(Form.getString(request, "cardnumber", Pattern.CARDNUMBER));
                    order.setFk_Users(Utils.getSessionUser(request).getId());
                    order.setFk_Cars(Integer.parseInt(String.valueOf(session.getAttribute("id"))));
                    order.setPassportData(Form.getString(request, "passportdata", Pattern.PASSPORT));
                    order.setTelephone(Form.getString(request, "telephone", Pattern.TELEPHONE));
                    order.setOrderDuration(Integer.parseInt(Form.getString(request, "duration", Pattern.INTEGER)));
                    dao.order.create(order);
                    return Actions.PROFILE.command;
                } else
                    return Actions.LOGIN.command;
            } catch (ParseException e) {
                return Actions.ERROR.command;
            } catch (SQLException e) {
                return Actions.ERROR.command;
            }
        }
    }
}
