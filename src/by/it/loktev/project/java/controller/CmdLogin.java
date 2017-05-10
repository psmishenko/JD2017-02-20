package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        if (!Form.isPost(request)){
            return null;
        }

        try {
            User user=new User();
            user.setId(0);
            user.setRoleId(2);
            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
            user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
            DAO dao=DAO.getInstance();
            List<User> list=dao.getUser().getAll(" where login='"+user.getLogin()+"' and password='"+user.getPassword()+"' ");
            if ( list.size()==1 ){
                HttpSession session=request.getSession();
                user=list.get(0);
                session.setAttribute("user",user);
                return Actions.PROFILE.command;
            }
            request.setAttribute(Messages.MSG_MESSAGE,"нет такого пользователя");
            return null;
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }
        return null;

    }
}
