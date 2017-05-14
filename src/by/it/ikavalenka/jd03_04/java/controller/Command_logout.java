package by.it.ikavalenka.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by USER on 05.05.2017.
 */
public class Command_logout implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return "/logout.jsp";
    }
}
