package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by user on 05.05.2017.
 */
public class CmdSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        User user = new User();
        try {
            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
            user.setId(0);
            user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
            user.setEmail(Form.getString(request,"email",Pattern.EMAIL));
            user.setFk_roles(2);
            DAO dao = DAO.getInstance();
            try {
                if( dao.user.create(user)) return Actions.LOGIN.command;
                else return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return Actions.ERROR.command;

            }
        } catch (ParseException e) {
            return Actions.ERROR.command;
        }

    }

}
