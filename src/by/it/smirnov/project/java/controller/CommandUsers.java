package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.User;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandUsers extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao= DAO.getInstance();
        List<User> list = null;
        String searchText = null;
        try {
            String where = "";
            searchText = request.getParameter("searchText");
            if (searchText != null){
                where = String.format(" WHERE LOWER(NAME) LIKE LOWER('%%%s%%')",searchText);
            }
            SingleLogger.getInstance().error(where);
            list = dao.getUser().getAll(where);
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("users", list);
        request.setAttribute("searchText", searchText);
        return null;
    }
}
