package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Valut;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandValuts extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao= DAO.getInstance();
        List<Valut> list = null;
        try {
            list = dao.getValut().getAll("");
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("valuts", list);
        return null;
    }
}
