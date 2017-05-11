package by.it.loktev.project.java.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationToCookies implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest _servletRequest, ServletResponse _servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest servletRequest=(HttpServletRequest)_servletRequest;
        HttpServletResponse servletResponse=(HttpServletResponse)_servletResponse;

        HttpSession session=servletRequest.getSession();
        if ( session.getAttribute("userlogin")!=null && session.getAttribute("userpasshash")!=null ) {
            String userLogin = session.getAttribute("userlogin").toString();
            String userPassHash = session.getAttribute("userpasshash").toString();

            Cookie loginCookie = new Cookie("ck_userlogin",userLogin);
            loginCookie.setMaxAge(60);
            servletResponse.addCookie(loginCookie);

            Cookie passwordCookie = new Cookie("ck_userpasshash",userPassHash);
            passwordCookie.setMaxAge(60);
            servletResponse.addCookie(passwordCookie);
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
            }

}
