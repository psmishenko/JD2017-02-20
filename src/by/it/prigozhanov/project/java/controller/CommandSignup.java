package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;


/**
 * Created by v-omf on 5/5/2017!
 */
public class CommandSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            User user = new User();

            try {
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setEmail(Form.getString(request, "email", Pattern.LOGIN));
                user.setPassportData(Form.getString(request, "passport_data", Pattern.LOGIN));
                user.setPassword(Form.getString(request, "password", Pattern.LOGIN));
                DAO dao = DAO.getInstance();
                if (dao.user.create(user)) return Actions.LOGIN.command;
                else return null;
            } catch (ParseException e) {
                return Actions.ERROR.command;
            } catch (SQLException e) {
                return Actions.ERROR.command;
            }

        }
    }
}
