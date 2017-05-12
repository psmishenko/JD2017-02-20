package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.Book;
import by.it.psmishenko.project.java.beans.Role;
import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 05.05.2017.
 */
 class CmdEditusers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        try {
        DAO dao = DAO.getInstance();
       if(Form.isPost(request)){
           if(request.getParameter("Update")!=null){
              User user = new User(/*Form.getInt(request,"id"),Form.getString("Login")*/);
               dao.user.update(user);
           }
                if(request.getParameter("Delete")!=null){
                    User user = new User(/*Form.getInt(request,"id"),Form.getString("Login")*/);
                    user.setId(Form.getInt(request,"id"));
                    dao.user.delete(user);
                }
            }

            List<Role> roles = dao.role.getAll("");
            List<User> users = dao.user.getAll("");
            request.getServletContext().setAttribute("roles",roles);
            request.setAttribute("allusers",users);
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
