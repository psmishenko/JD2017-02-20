package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.User;
import by.it.psmishenko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by user on 05.05.2017.
 */
public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if(!Form.isPost(request)){
            return null;
        }else {
            try {
                User user = new User();
                user.setId(0);
                user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
                user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
                DAO dao = DAO.getInstance();
                String where = String.format("WHERE Login='%s' AND Password='%s'",user.getLogin(),
                        user.getPassword());
                List<User>  users = dao.user.getAll(where);
                if (users.size()==1){
                    HttpSession session = request.getSession();
                    user = users.get(0);
                    session.setAttribute("user",user);
                    return Actions.PROFILE.command;
                } else {
                    request.setAttribute(Messages.MSG_MESSAGE,"Not found");
                    return null;
                }
            } catch (ParseException | SQLException e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
                e.printStackTrace();
            }
        }
        return null;
    }
}
