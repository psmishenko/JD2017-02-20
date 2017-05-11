package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.filters.ICookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandLogout extends Action{
    private void deleteCookie(String cookieName,
                           HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (FormUtils.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();

            deleteCookie(ICookies.LOGIN, response);
            deleteCookie(ICookies.PASSWORD, response);

            return Actions.LOGIN.command;
        }
        return null;
    }
}
