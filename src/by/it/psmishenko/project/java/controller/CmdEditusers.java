package by.it.psmishenko.project.java.controller;


import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


 class CmdEditusers extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        try {
        DAO dao = DAO.getInstance();
        User cUser = Utils.getSessionUser(request);
       if(Form.isPost(request)&&cUser!=null){
        if(cUser.getFk_roles() == 1) {
            if (request.getParameter("Update") != null) {
                User user = new User(
                        Form.getInt(request, "id"),
                        Form.getString(request, "login", Pattern.LOGIN),
                        Form.getString(request, "password", Pattern.PASSWORD),
                        Form.getString(request, "email", Pattern.EMAIL),
                        Form.getInt(request, "fk_Role")
                );
               if(dao.user.update(user)) request.setAttribute(Messages.MSG_MESSAGE,"user updated");
            }
            if (request.getParameter("Delete") != null) {
                User user = new User();
                user.setId(Form.getInt(request, "id"));
                if(dao.user.delete(user)) request.setAttribute(Messages.MSG_MESSAGE,"user deleted");
            }
        } else request.setAttribute(Messages.MSG_ERROR, "access denied");
           }
            List<User> users = dao.user.getAll("");
            request.setAttribute("allusers",users);
        } catch (SQLException | ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
