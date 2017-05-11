package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by GN on 08.05.2017.
 */
public class CmdAllbooks extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
            DAO dao = DAO.getInstance();
            try {
                List<Book> books = dao.book.getAll("");
                request.setAttribute("allbooks",books);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

}
