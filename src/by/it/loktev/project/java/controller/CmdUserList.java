package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class CmdUserList extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        try {
            DAO dao=DAO.getInstance();
            List<User> list= dao.getUser().getAll("");
            request.setAttribute("users",list);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }

        return null;
    }
}
