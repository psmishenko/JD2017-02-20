package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;
import by.it.radivonik.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        if (!FormUtils.isPost(req))
            return null;

        try {
            String login = FormUtils.getString(req, "login", Pattern.LOGIN);
            String password = FormUtils.getString(req, "password", Pattern.PASSWORD);
            Map<String, String> filter = new HashMap<>();
            filter.put("login", login);
            filter.put("password", password);
            DAO dao = DAO.getInstance();
            List<User> users = dao.getUser().getAll(filter);
            if (users.size() == 1) {
                HttpSession session = req.getSession();
                User user = users.get(0);
                session.setAttribute("userActive", user);
                return Actions.PROFILE.command;
//              req.setAttribute(Messages.MSG_INFO, String.format("Вход пользователя %s произведен", login));
            }
            else {
                req.setAttribute(Messages.MSG_ERROR, String.format("У пользователя %s с введенным паролем нет доступа", login));
            }
        }
        catch (ParseException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
        }
        return null;
    }
}
