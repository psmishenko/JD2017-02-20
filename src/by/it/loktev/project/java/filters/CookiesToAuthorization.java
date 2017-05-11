package by.it.loktev.project.java.filters;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.controller.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CookiesToAuthorization implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest _servletRequest, ServletResponse _servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest servletRequest=(HttpServletRequest)_servletRequest;
        HttpServletResponse servletResponse=(HttpServletResponse)_servletResponse;

        HttpSession session=servletRequest.getSession();
        if ( session.getAttribute("userlogin")==null || session.getAttribute("userpasshash")==null ) {

            String userLogin=null;
            String userPassHash=null;

            Cookie[] cookies=servletRequest.getCookies();
            for(int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("ck_userlogin")) {
                    userLogin = cookie.getValue();
                }
                if (cookie.getName().equals("ck_userpasshash")) {
                    userPassHash = cookie.getValue();
                }
            }

            if ( userLogin!=null && userPassHash!=null ){
                Log.write("Session authorization closed but cookies authorization exists - trying to renew session authorization...");

                try {
                    User user=new User();
                    user.setLogin(userLogin);
                    user.setPassHash(userPassHash);
                    if ( Lib.authorize(servletRequest,user) ) {
                        Log.write("Session renewed successfully!");
                    }
                    else{
                        Log.write("Session renew failed (no such user).");
                    }
                } catch (ParseException e) {
                    Log.write("Session renew failed ("+e.toString()+").");
                } catch (SQLException e) {
                    Log.write("Session renew failed ("+e.toString()+").");
                }


            }

        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }

}
