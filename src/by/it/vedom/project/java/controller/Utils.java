package by.it.vedom.project.java.controller;

import by.it.vedom.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {

    static User getSessionUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("user");
        if (ob!=null && ob instanceof User){
            //нашли пользователя в сессии
            return (User)ob;
        } else {
            //не нашли пользователя в сессии
            return null;
        }
    }

}
