package by.it.ikavalenka.project.java.controller;

import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.client;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Utils {
    public Utils() {
    }

    static administrator getSessionAdministrstor (HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object ob = session.getAttribute("administrator");
        session.setMaxInactiveInterval(30);
        return ob != null && ob instanceof administrator?(administrator) ob:null;
    }
    static  client getSessionClient (HttpServletRequest request){
        HttpSession session = request.getSession();
        Object object = session.getAttribute("client");
        session.setMaxInactiveInterval(30);
        return object!=null && object instanceof client?(client)object:null;
    }
}
