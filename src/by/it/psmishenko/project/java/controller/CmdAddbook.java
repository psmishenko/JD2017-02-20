package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;


public class CmdAddbook extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        User user = Utils.getSessionUser(request);
        if (user == null) {
            return Actions.LOGIN.command;
        }
        if (!Form.isPost(request)) {
            return null;
        } else {
            Book book = new Book();
            try {
                book.setLid(0);
                book.setAuthor(Form.getString(request, "author", Pattern.AUTHOR));
                book.setTitle(Form.getString(request, "title", Pattern.TITLE));
                book.setYear(Form.getInt(request, "year"));
                book.setIsbn(Form.getString(request, "isbn", Pattern.ISBN));
                book.setLid(Form.getInt(request, "lid"));
                book.setFk_users(user.getId());
                DAO dao = DAO.getInstance();
                    if (dao.book.create(book)) return Actions.ALLBOOKS.command;
                    else return null;

            } catch (ParseException | SQLException e) {
                e.printStackTrace();
                return Actions.ERROR.command;
            }
        }
    }
}
