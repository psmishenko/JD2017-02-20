package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdUserSetPass extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        int userId = Integer.parseInt(request.getParameter("usid"));
        DAO dao = DAO.getInstance();
        try {
            User user=dao.getUser().read(userId);
            user.setPassHash(DigestUtils.md5Hex(request.getParameter("uspass")));
            dao.getUser().update(user);

            return Actions.USERLIST.command;
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }

        return null;
    }
}
