package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    public Utils() {
    }

    static User getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object ob = session.getAttribute("user");
        return ob != null && ob instanceof User?(User)ob:null;
    }
}
