package by.it.Zyryanov.project_v2.java.controller;

import by.it.Zyryanov.project_v2.java.beans.Users;
import by.it.Zyryanov.project_v2.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            Users user = new Users();
            try {
                user.setId(0);
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setEmail(Form.getString(request, "email", Pattern.EMAIL));
                user.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
                user.setFk_Roles(2);
                DAO dao = DAO.getDao();
                if (dao.user.create(user))
                    return Actions.LOGIN.command;
                else
                    return null;
            } catch (ParseException e) {
                return Actions.ERROR.command;
            }
        }
    }
}
