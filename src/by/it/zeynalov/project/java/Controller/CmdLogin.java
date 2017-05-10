package by.it.zeynalov.project.java.Controller;


import by.it.zeynalov.project.java.beans.User;
import by.it.zeynalov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            User user = new User();
            user.setId(0);
            try {
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setLogin(Form.getString(request, "password", Pattern.PASSWORD));
                DAO dao = DAO.getInstance();
                String where = String.format(" WHERE Login='%s' AND Password='%s'",
                        user.getLogin(), user.getPassword());
                List<User> list = dao.users.getAll(where);
                if (list.size() == 1) {
                    HttpSession session = request.getSession();
                    user = list.get(0);
                    session.setAttribute("user", user);
                    return Actions.PROFILE.command;
                } else {
                    request.setAttribute(Messages.MSG_MESSAGE,"Нет такого пользователя");
                    return null;
                }
            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
                e.printStackTrace();
            }
            return null;
        }
    }
}
