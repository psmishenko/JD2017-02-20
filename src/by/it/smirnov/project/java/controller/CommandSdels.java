package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Sdel;
import by.it.smirnov.project.java.bean.User;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

import static by.it.smirnov.project.java.controller.FormUtils.*;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandSdels extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao= DAO.getInstance();
        List<Sdel> list = null;
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String where = "";
                User currentUser = getSessionUser(request);
                if (
                        (session.getAttribute("admin")== null ||
                        (Integer)session.getAttribute("admin") != 1)
                    &&
                        (currentUser != null)
                   ){
                    where = String.format(" WHERE idsysoper in (select id from sysopers where iduser=%d)",
                            currentUser.getId());
                }
                int countRec = dao.getSdel().getCount(where);
                request.setAttribute("countRec", countRec);
                int start = FormUtils.getIntDef(request, "start", 0);
                int step = FormUtils.getIntDef(request, "step", 5);
                String limit=String.format(" ORDER BY ID LIMIT %d,%d ", start, step);
                list = dao.getSdel().getAll(where+limit);
            }
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("sdels", list);
        return null;
    }
}
