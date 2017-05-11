package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.User;
import by.it.prigozhanov.project.java.controller.Action;
import by.it.prigozhanov.project.java.controller.Actions;
import by.it.prigozhanov.project.java.controller.Form;
import by.it.prigozhanov.project.java.controller.Utils;
import by.it.prigozhanov.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandProfile extends Action {
    public CommandProfile() {
    }

    public Action execute(HttpServletRequest request) {
        if(Form.isPost(request) && request.getParameter("logout") != null) {
            HttpSession user1 = request.getSession();
            user1.invalidate();
            return Actions.LOGIN.command;
        } else {
            User user = Utils.getSessionUser(request);
            if(user != null) {
                DAO var3 = DAO.getInstance();
            }

            return null;
        }
    }
}
