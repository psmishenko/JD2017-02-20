package by.it.zeynalov.project.java.Controller;


import by.it.zeynalov.project.java.beans.Orders;
import by.it.zeynalov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CmdIndex extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        request.setAttribute(Messages.MSG_MESSAGE, "ok");
        DAO dao = DAO.getInstance();
        try {
            List<Orders> ods = dao.orders.getAll("");
            request.setAttribute("ods", ods);
        }catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR, e.toString());
        }
        return null;
    }
}
