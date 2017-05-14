package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;


class CmdEditUserBook extends Action {
   @Override
   public Action execute(HttpServletRequest request) {
     /*  try {
           DAO dao = DAO.getInstance();
       if(Form.isPost(request)) {
           request.setAttribute(Messages.MSG_MESSAGE,"ok");
       }

           Book book = dao.book.read(Form.getInt(request,"id"));
            request.setAttribute("book",book);
       } catch (SQLException | ParseException e) {
               e.printStackTrace();
               request.setAttribute(Messages.MSG_ERROR,e.toString());
           }*/
       return null;
   }
}
