package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Sdel;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandSdels extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao= DAO.getInstance();
        List<Sdel> list = null;
        try {
            list = dao.getSdel().getAll("");
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("sdels", list);
        return null;
    }
}
