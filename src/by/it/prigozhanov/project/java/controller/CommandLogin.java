package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by v-omf on 5/5/2017!
 */
public class CommandLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {



        if (!Form.isPost(request)) {
            return null;
        } else
        {
            User user = new User();
            user.setId(0);
            try {
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setPassword(Form.getString(request, "password", Pattern.LOGIN));
                DAO dao = DAO.getInstance();
                String where = String.format(" WHERE Login='%s' AND Password='%s'",
                        user.getLogin(), user.getPassword());
                List<User> list = dao.user.getAll(where);
                if (list.size()==1) {
                    HttpSession session = request.getSession();
                    user = list.get(0);
                    session.setAttribute("user", user);
                    return Actions.PROFILE.command;
                } else {
                    request.setAttribute(Messages.MSG_MESSAGE, "Нет такого пользователя");
                    return null;
                }

            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }
}
