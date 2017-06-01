package by.it.ikavalenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CommandLogout extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request)&& request.getParameter("Logout")!=null){
            HttpSession user = request.getSession();
            user.invalidate();
            return Actions.LOGIN.command;
        }
        else return Actions.ERROR.command;
    }
}
