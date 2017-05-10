package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        if (!FormUtils.isPost(req))
            return null;

        User user = new User();
        try {
            user.setId(0);
            user.setLogin(FormUtils.getString(req, "login", Pattern.LOGIN));
            user.setPassword(FormUtils.getString(req, "password",  Pattern.PASSWORD));
            user.setEmail(FormUtils.getString(req, "email", Pattern.EMAIL));
            user.setIdRole(2);
            DAO dao = DAO.getInstance();
            if (dao.getUser().create(user))
                return null;
            else
                return  null;
        }
        catch (ParseException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(Messages.MSG_ERROR, e.getMessage());
        }
        return  null;
    }
}
