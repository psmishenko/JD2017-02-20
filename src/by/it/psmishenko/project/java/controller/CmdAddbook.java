package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by GN on 08.05.2017.
 */
public class CmdAddbook extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        Book book = new Book();
        try {
            book.setLid(0);
            book.setAuthor(Form.getString(request,"author",Pattern.AUTHOR));
            book.setTitle(Form.getString(request,"title",Pattern.TITLE));
            book.setYear(Form.getInt(request,"year"));
            book.setIsbn(Form.getString(request,"isbn",Pattern.ISBN));
            book.setLid(Form.getInt(request,"lid"));

            DAO dao = DAO.getInstance();
            try {
                if(dao.book.create(book)) return Actions.ALLBOOKS.command ;
                else return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return Actions.ERROR.command;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return Actions.ERROR.command;
        }
    }
}
