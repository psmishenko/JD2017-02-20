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
        User cUser = Utils.getSessionUser(request);
        if (cUser!=null) {
            if(cUser.getFk_roles() == 1) {
        try {
        DAO dao = DAO.getInstance();

       if(Form.isPost(request)){

            if (request.getParameter("Update") != null) {
                User user = new User(
                        Form.getInt(request, "id"),
                        Form.getString(request, "login", Pattern.LOGIN),
                        Form.getString(request, "password", Pattern.PASSWORD),
                        Form.getString(request, "email", Pattern.EMAIL),
                        Form.getInt(request, "fk_Role")
                );
                if (dao.user.update(user)) request.setAttribute(Messages.MSG_MESSAGE, "user updated");
            }
            if (request.getParameter("Delete") != null) {
                User user = new User();
                user.setId(Form.getInt(request, "id"));
                if (dao.user.delete(user)) request.setAttribute(Messages.MSG_MESSAGE, "user deleted");
            }

           }
            List<User> users = dao.user.getAll("");
            request.setAttribute("allusers",users);
        } catch (SQLException | ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
            e.printStackTrace();
        }
            } else return Actions.ERROR.command;

        } else return Actions.LOGIN.command;
        return null;
    }
}
