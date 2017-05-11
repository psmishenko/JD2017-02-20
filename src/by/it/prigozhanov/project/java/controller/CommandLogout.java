package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by v-omf on 5/5/2017!
 */
public class CommandLogout extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        if(Form.isPost(request) && request.getParameter("logout") != null) {
            HttpSession user1 = request.getSession();
            user1.invalidate();
            return Actions.LOGIN.command;
        }
        else return Actions.ERROR.command;
    }
}
