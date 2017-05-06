package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CommandSignUp extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        User user = new User();
        try {
            user.setId(0);
            user.setLogin(Form.getString(req, "login", Pattern.LOGIN));
            user.setPassword(Form.getString(req, "password",  Pattern.PASSWORD));
            user.setEmail(Form.getString(req, "email", Pattern.EMAIL));
            user.setIdRole(2);
            DAO dao = DAO.getInstance();
            if (dao.getUser().create(user))
                return Actions.LOGIN.command;
            else
                return  null;
        }
        catch (ParseException e) {
            return Actions.ERROR.command;
        }
        catch (SQLException e) {
            return Actions.ERROR.command;
        }
    }
}
