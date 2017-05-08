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
            book.setYear(Integer.parseInt(Form.getString(request,"year",Pattern.YEAR)));
            book.setIsbn(Form.getString(request,"isbn",Pattern.ISBN));
            book.setLid(Integer.parseInt(Form.getString(request,"lid",Pattern.LID)));
            book.setFk_users(2); // пока будет на определённого пользователя, нужно потом добавить на залогиненного
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
