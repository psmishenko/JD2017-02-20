package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


public class CmdAllbooks extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        try {
            DAO dao = DAO.getInstance();
            List<Book> books = dao.book.getAll("");
             User user = Utils.getSessionUser(request);
            if(Form.isPost(request)){
                if(user==null) return Actions.LOGIN.command;
                Book book = new Book(Form.getInt(request,"id"),
                        Form.getString(request,"author",Pattern.AUTHOR),
                        Form.getString(request,"title",Pattern.TITLE),
                        Form.getInt(request,"year"),  Form.getString(request,"isbn",Pattern.ISBN),
                        Form.getInt(request,"lid"),user.getId());
                dao.book.create(book);
            }
                request.setAttribute("allbooks",books);
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        return null;
    }

}
