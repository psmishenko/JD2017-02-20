package by.it.prigozhanov.project.java.controller;


import by.it.prigozhanov.project.java.beans.Role;
import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.controller.Action;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by v-omf on 5/5/2017!
 */
public class CommandEditUsers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        User admin = Utils.getSessionUser(request);
        request.setAttribute("admin", admin);
        if (admin!= null && admin.getFkRole() == 1) {
            DAO dao = DAO.getInstance();
            try {
                if (Form.isPost(request)) {
                    if (request.getParameter("Create") != null) {
                        User user = new User(
                                0,
                                Form.getString(request, "passportdata", Pattern.PASSPORT),
                                Form.getString(request, "login", Pattern.LOGIN),
                                Form.getString(request, "password", Pattern.PASSWORD),
                                Form.getString(request, "email", Pattern.EMAIL),
                                0
                        );
                        dao.user.create(user);
                    }
                    if (request.getParameter("Update") != null) {
                        User user = new User(
                                Form.getInt(request, "id"),
                                Form.getString(request, "passportdata", Pattern.PASSPORT),
                                Form.getString(request, "login", Pattern.LOGIN),
                                Form.getString(request, "password", Pattern.PASSWORD),
                                Form.getString(request, "email", Pattern.EMAIL),
                                Form.getInt(request, "fk_role")
                        );
                        dao.user.update(user);
                    }
                    if (request.getParameter("Delete") != null) {
                        User user = new User();
                        user.setId(Form.getInt(request, "id"));
                        dao.user.delete(user);
                    }
                }
            } catch (SQLException e) {
                request.setAttribute(Messages.MSG_MESSAGE, "Ошибка базы данных, Не удаётся произвести действие, проверьте активные заказы пользователя");
            } catch (ParseException e) {
                e.printStackTrace();
            }


            try {
                List<Role> roles = dao.role.getAll("");
                List<User> users = dao.user.getAll("");
                request.getServletContext().setAttribute("roles", roles);
                request.setAttribute("users", users);

            } catch (SQLException e) {
                request.setAttribute(Messages.MSG_MESSAGE, "Ошибка базы данных");
            }
            return null;

        } else
            return Actions.LOGIN.command;
    }

}
