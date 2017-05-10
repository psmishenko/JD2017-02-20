package by.it.psmishenko.project.java.controller;

import by.it.psmishenko.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by GN on 10.05.2017.
 */
public class Utils {
    static User getSessionUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("user");
        if (ob!=null && ob instanceof User){
            return (User)ob;
        } else return null;
    }
}
