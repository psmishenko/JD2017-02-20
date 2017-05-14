package by.it.smirnov.project.java.filters;

import by.it.smirnov.project.java.bean.User;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by aleksey.smirnov on 11.05.2017.
 */
public class AddCookies implements Filter {
    private static final int CookieMaxAgeSec = 60;

    private void addCookie(String cookieName,
                           String cookieValue,
                           HttpServletResponse response,
                           int cookieMaxAgeSec) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieMaxAgeSec);
        response.addCookie(cookie);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp=(HttpServletResponse)servletResponse;
        HttpServletRequest httpReq=(HttpServletRequest)servletRequest;

        HttpSession session = httpReq.getSession(false);
        if (session != null &&
                session.getAttribute("currentuser") != null &&
                session.getAttribute("currentuser") instanceof User) {
            User user = (User) session.getAttribute("currentuser");
            addCookie(ICookies.LOGIN, user.getLogin(), httpResp, CookieMaxAgeSec);
            addCookie(ICookies.PASSWORD, user.getPassword(), httpResp, CookieMaxAgeSec);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
