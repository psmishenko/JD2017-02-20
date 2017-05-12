package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Role;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {

        DAO dao = DAO.getInstance();
        try {
            if (Form.isPost(request)) {
                if (request.getParameter("Update") != null) {
                    User user = new User(
                            Form.getInt(request, "id"),
                            Form.getString(request, "login", Pattern.LOGIN),
                            Form.getString(request, "password", Pattern.PASSWORD),
                            Form.getString(request, "email", Pattern.EMAIL),
                            Form.getInt(request,"fk_Role")
                            );
                    dao.user.update(user);
                }
                if (request.getParameter("Delete") != null) {
                    User user = new User();
                    user.setId(Form.getInt(request, "id"));
                    dao.user.delete(user);
                }
            }
            //List<Role> roles = dao.role.getAll("");
            List<User> users = dao.user.getAll("");
            //request.getServletContext().setAttribute("roles", roles);
            request.setAttribute("users", users);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,e);
            e.printStackTrace();
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e);
            e.printStackTrace();
        }
        return null;
    }
}
