package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdProfile extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        if (!Form.isPost(request)){

            try {
                DAO dao=DAO.getInstance();
                List<Task> list= dao.getTask().getAll(" where execuserid="+Lib.getUserId(request)+" and statusid in (2,3) ");
                request.setAttribute("tasks",list);
            } catch (SQLException e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
            }

            return null;
        }

        if ( request.getParameter("logout")!=null ){

            HttpSession session=request.getSession();
            session.invalidate();

            Cookie loginCookie = new Cookie("ck_userlogin","");
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);

            Cookie passwordCookie = new Cookie("ck_userpasshash","");
            passwordCookie.setMaxAge(0);
            response.addCookie(passwordCookie);

            return Actions.LOGIN.command;
        }

        return null;
    }
}
