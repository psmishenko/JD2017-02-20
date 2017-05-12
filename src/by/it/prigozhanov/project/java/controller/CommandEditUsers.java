package by.it.prigozhanov.project.java.controller;


import by.it.prigozhanov.project.java.beans.Role;
import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.controller.Action;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by v-omf on 5/5/2017!
 */
public class CommandEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request)) {
            if (request.getParameter("Update")!=null) {
                try {
                    User user = new User(
                            Integer.parseInt(Form.getString(request, "id", Pattern.INTEGER)),
                            Form.getString(request, "Login", Pattern.LOGIN),
                            Form.getString(request, "Passportdata", Pattern.PASSPORT),
                            Form.getString(request, "Password", Pattern.PASSWORD),
                            Form.getString(request, "Email", Pattern.EMAIL),
                            Integer.parseInt(Form.getString(request, "fk_role", Pattern.INTEGER))
                    );
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        DAO dao = DAO.getInstance();

        try {
            List<Role> roles = dao.role.getAll("");
            List<User> users = dao.user.getAll("");
            request.getServletContext().setAttribute("roles", roles);
            request.setAttribute("users", users);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
