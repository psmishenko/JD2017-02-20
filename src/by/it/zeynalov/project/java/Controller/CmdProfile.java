package by.it.zeynalov.project.java.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }
        return null;
    }
}
