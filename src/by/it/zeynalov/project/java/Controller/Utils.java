package by.it.zeynalov.project.java.Controller;

import by.it.zeynalov.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {

    static User getSessionUser(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object ob=session.getAttribute("user");
        if (ob!=null && ob instanceof User){
            return (User)ob;
        } else {
            return null;
        }
    }
}
