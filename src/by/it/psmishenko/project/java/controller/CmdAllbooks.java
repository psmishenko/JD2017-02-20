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
            List<User> users = dao.user.getAll("");
             User sessionUser = Utils.getSessionUser(request);
            if(Form.isPost(request)){
                if(sessionUser==null) return Actions.LOGIN.command;
                Book book = dao.book.read(Form.getInt(request,"id"));
                   book.setFk_users(sessionUser.getId());
                   if (dao.book.create(book)) return Actions.PROFILE.command;
            }
                request.setAttribute("users",users);
                request.setAttribute("allbooks",books);
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
                request.setAttribute(Messages.MSG_ERROR,e.toString());
            }
        return null;
    }

}
