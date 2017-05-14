package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;


class CmdDeleteUserBook extends Action {
   @Override
   public Action execute(HttpServletRequest request) {
       if(Form.isPost(request)){
           DAO dao = DAO.getInstance();
           try {
               Book book = dao.book.read(Form.getInt(request,"id"));
               if (dao.book.delete(book)) return Actions.PROFILE.command;
           } catch (SQLException | ParseException e) {
               e.printStackTrace();
               request.setAttribute(Messages.MSG_ERROR,e.toString());
           }
       }
       return null;
   }
}
