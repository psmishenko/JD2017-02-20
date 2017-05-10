package by.it.loktev.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        if (!Form.isPost(request)){
            return null;
        }

        if ( request.getParameter("logout")!=null ){
            HttpSession session=request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }

        return null;
    }
}
