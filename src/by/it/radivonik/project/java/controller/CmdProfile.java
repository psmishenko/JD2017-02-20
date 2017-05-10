package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Radivonik on 10.05.2017.
 */
public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest req) {
        if (FormUtils.isPost(req) && req.getParameter("logout")!= null) {
            HttpSession session = req.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }
        return null;
    }
}
