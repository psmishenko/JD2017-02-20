package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;


class CmdEditUserBook extends Action {
   @Override
   public Action execute(HttpServletRequest request) {

     try {
             DAO dao = DAO.getInstance();
             Book book = dao.book.read(Form.getInt(request,"id"));
             if (Form.isPost(request)) {
                 Book newBook = new Book(book.getId(), Form.getString(request, "author", Pattern.AUTHOR),
                         Form.getString(request, "title", Pattern.TITLE),
                         Form.getInt(request, "year"),
                         Form.getString(request, "isbn", Pattern.ISBN),
                         Form.getInt(request, "lid"),
                         book.getFk_users());
                 if (dao.book.update(newBook)) return Actions.PROFILE.command;
             }

             request.setAttribute("book", book);
       } catch (SQLException | ParseException e) {
               e.printStackTrace();
               request.setAttribute(Messages.MSG_ERROR,e.toString());
           }
       return null;
   }
}
