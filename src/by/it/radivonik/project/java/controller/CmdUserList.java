package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 10.05.2017.
 */
public class CmdUserList extends Action {
    @Override
    Action execute(HttpServletRequest req) {
//        if (!FormUtils.isPost(req))
//            return null;

        List<User> users = null;
        try {
            DAO dao = DAO.getInstance();
            users = dao.getUser().getAll("");
        }
        catch (SQLException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        req.setAttribute("users", users);
        return null;
    }
}
