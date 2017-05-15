package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.KursValut;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandKursValuts extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao= DAO.getInstance();
        List<KursValut> list = null;
        try {
            String where = "";
            int countRec = dao.getKursValut().getCount(where);
            request.setAttribute("countRec", countRec);
            int start = FormUtils.getIntDef(request, "start", 0);
            int step = FormUtils.getIntDef(request, "step", 10);
            String limit=String.format(" ORDER BY ID LIMIT %d,%d ", start, step);
            list = dao.getKursValut().getAll(where+limit);
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("kursvaluts", list);
        return null;
    }
}
