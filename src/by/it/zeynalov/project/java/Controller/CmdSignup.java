package by.it.zeynalov.project.java.Controller;

import by.it.zeynalov.project.java.dao.DAO;
import by.it.zeynalov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            User user = new User();
            try {
                user.setId(0);
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setEmail(Form.getString(request, "email", Pattern.EMAIL));
                user.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
                user.setFc_rolles(2);
                DAO dao = DAO.getInstance();
                try {
                    if (dao.users.create(user))
                        return Actions.LOGIN.command;
                    else
                        return null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ParseException e) {
                return Actions.ERROR.command;
            }
            return Actions.LOGIN.command;
        }
    }
}
