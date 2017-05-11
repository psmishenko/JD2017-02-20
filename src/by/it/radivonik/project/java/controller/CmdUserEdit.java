package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Role;
import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdUserEdit extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        String action = req.getParameter("action").toLowerCase();
        if (!FormUtils.isPost(req) || action == null)
            return Actions.ERROR.command;

        String idStr = req.getParameter("id");
        int id = idStr.isEmpty() ? 0 : Integer.parseInt(idStr);

        try {
            DAO dao = DAO.getInstance();
            User user;
            if (id == 0)
                user = new User();
            else
                user = dao.getUser().read(id);

            if (action.equals("delete")) {
                dao.getUser().delete(user);
                return Actions.USERLIST.command;
            }

            if (action.equals("create") || action.equals("update")) {
                List<Role> roles = dao.getRole().getAll("");
                req.setAttribute("user", user);
                req.setAttribute("roles", roles);
                return null;
            }

            if (action.equals("save")) {
                user.setId(id);
                user.setLogin(FormUtils.getString(req, "login", IPattern.LOGIN));
                user.setPassword(FormUtils.getString(req, "password", IPattern.PASSWORD));
                user.setEmail(FormUtils.getString(req, "email", IPattern.EMAIL));
                user.setIdRole(Integer.parseInt(req.getParameter("id_role")));

                if (user.getId() == 0)
                    dao.getUser().create(user);
                else
                    dao.getUser().update(user);

                return Actions.USERLIST.command;
            }
        }
        catch (ParseException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        return  null;
    }
}
