package by.it.sorokoee.project.java.controller;

import by.it.sorokoee.project.java.beans.Good;
import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.daouniv.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }
        User user= Utils.getSessionUser(request);
        if (user!=null) {
            DAO dao= DAO.getInstance();
            try {
                List<Good> goods=dao.good.getAll("WHERE fk_users="+user.getId());
                request.setAttribute("goods",goods);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
