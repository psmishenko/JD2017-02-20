package by.it.zeynalov.project.java.Controller;


import by.it.zeynalov.project.java.beans.Roles;
import by.it.zeynalov.project.java.beans.User;
import by.it.zeynalov.project.java.dao.DAO;

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
                            Form.getInt(request, "fc_rolles")
                    );
                    dao.users.update(user);
                }
                if (request.getParameter("Delete") != null) {
                    User user = new User();
                    user.setId(Form.getInt(request, "id"));
                    dao.users.delete(user);
                }
            }
            //List<Roles> roles = dao.roles.getAll("");
            List<User> users = dao.users.getAll("");
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
