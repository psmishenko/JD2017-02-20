package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.dao.DAO;
import by.it.radivonik.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        try {
            String login = FormUtils.getString(req, "login", Pattern.LOGIN);
            String password = FormUtils.getString(req, "password", Pattern.PASSWORD);
            Map<String,String> filter = new HashMap<>();
            filter.put("login", login);
            filter.put("password", password);
            DAO dao = DAO.getInstance();
            if (dao.getUser().getAll(filter).size() == 1)
                req.setAttribute(Messages.MSG_INFO, String.format("Вход пользователя %s произведен", login));
            else {
                req.setAttribute(Messages.MSG_ERROR, String.format("У пользователя %s с введенным паролем нет доступа", login));
                return Actions.ERROR.command;
            }
        }
        catch (ParseException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
            return Actions.ERROR.command;
        }
        return null;
    }
}
