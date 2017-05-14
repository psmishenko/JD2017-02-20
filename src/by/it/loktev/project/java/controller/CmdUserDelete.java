package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdUserDelete extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        int userId = Integer.parseInt(request.getParameter("usid"));
        Log.write("удаляется пользователь "+userId);
        DAO dao = DAO.getInstance();
        try {
            User user=new User();
            user.setId(userId);
            dao.getUser().delete(user);

            return Actions.USERLIST.command;
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }

        return null;
    }
}
