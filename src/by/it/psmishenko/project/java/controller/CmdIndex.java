package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 05.05.2017.
 */
 class CmdIndex extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        request.setAttribute(Messages.MSG_MESSAGE,"ok");
        DAO dao = DAO.getInstance();
        try {
            List<Book> books = dao.book.getAll("");
            request.setAttribute("allbooks",books);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
