package by.it.loktev.project.java.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        if (!Form.isPost(request)){
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
